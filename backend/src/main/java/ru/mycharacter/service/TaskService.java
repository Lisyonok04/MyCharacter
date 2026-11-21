package ru.mycharacter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ru.mycharacter.dto.CompleteTaskResponse;
import ru.mycharacter.dto.StatChangeDto;
import ru.mycharacter.dto.TaskDto;
import ru.mycharacter.dto.TaskListResponse;
import ru.mycharacter.entity.PlayerBranchEntity;
import ru.mycharacter.entity.PlayerEntity;
import ru.mycharacter.entity.PlayerStatEntity;
import ru.mycharacter.entity.QuestCompletionEntity;
import ru.mycharacter.entity.QuestEntity;
import ru.mycharacter.entity.QuestStatEntity;
import ru.mycharacter.helper.CharacterFormulaHelper;
import ru.mycharacter.repository.PlayerBranchRepository;
import ru.mycharacter.repository.PlayerRepository;
import ru.mycharacter.repository.PlayerStatRepository;
import ru.mycharacter.repository.QuestCompletionRepository;
import ru.mycharacter.repository.QuestRepository;
import ru.mycharacter.repository.QuestStatRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final PlayerRepository playerRepository;
    private final PlayerBranchRepository playerBranchRepository;
    private final PlayerStatRepository playerStatRepository;
    private final QuestRepository questRepository;
    private final QuestStatRepository questStatRepository;
    private final QuestCompletionRepository questCompletionRepository;

    @Transactional(readOnly = true)
    public TaskListResponse getTasks(Long playerId, Long branchId) {
        if (!playerRepository.existsById(playerId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found");
        }

        List<QuestEntity> quests = branchId == null
                ? questRepository.findAllWithBranch()
                : questRepository.findByBranchIdWithBranch(branchId);

        Set<Long> selectedBranchIds = playerBranchRepository.findByPlayerId(playerId).stream()
                .map(pb -> pb.getBranch().getId())
                .collect(Collectors.toSet());

        if (!selectedBranchIds.isEmpty()) {
            quests = quests.stream()
                    .filter(quest -> selectedBranchIds.contains(quest.getBranch().getId()))
                    .toList();
        }

        LocalDate today = LocalDate.now();
        List<TaskDto> tasks = quests.stream()
                .map(quest -> new TaskDto(
                        quest.getId(),
                        quest.getBranch().getId(),
                        quest.getBranch().getCode(),
                        quest.getBranch().getName(),
                        quest.getTitle(),
                        quest.getDescription(),
                        quest.getDifficulty(),
                        quest.getBaseXp(),
                        questCompletionRepository.existsByPlayerIdAndQuestIdAndCompletionDate(
                                playerId,
                                quest.getId(),
                                today
                        )
                ))
                .toList();

        return new TaskListResponse(tasks);
    }

    @Transactional
    public CompleteTaskResponse completeTask(Long taskId, Long playerId) {
        PlayerEntity player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found"));

        QuestEntity quest = questRepository.findById(taskId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));

        Long branchId = quest.getBranch().getId();
        PlayerBranchEntity playerBranch = playerBranchRepository.findByPlayerIdAndBranchId(playerId, branchId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Сначала выберите категорию этого задания"
                ));

        LocalDate today = LocalDate.now();
        if (questCompletionRepository.existsByPlayerIdAndQuestIdAndCompletionDate(playerId, taskId, today)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Задание уже выполнено сегодня");
        }

        List<QuestStatEntity> questStats = questStatRepository.findByQuestId(taskId);
        BigDecimal multiplier = questStats.stream()
                .map(QuestStatEntity::getXpMultiplier)
                .max(Comparator.naturalOrder())
                .orElse(BigDecimal.ONE);

        int xpAwarded = Math.max(1, (int) Math.round(quest.getBaseXp() * multiplier.doubleValue()));

        int oldLevel = player.getLevel();
        int totalXp = player.getTotalXp() + xpAwarded;
        int newLevel = Math.max(oldLevel, CharacterFormulaHelper.calculateLevel(totalXp));

        player.setTotalXp(totalXp);
        player.setLevel(newLevel);
        updateStreak(player, today);
        playerRepository.save(player);

        int branchXp = playerBranch.getBranchXp() + xpAwarded;
        playerBranch.setBranchXp(branchXp);
        playerBranch.setBranchLevel(Math.max(
                playerBranch.getBranchLevel(),
                CharacterFormulaHelper.calculateLevel(branchXp)
        ));
        playerBranchRepository.save(playerBranch);

        List<StatChangeDto> statChanges = new ArrayList<>();
        for (QuestStatEntity questStat : questStats) {
            PlayerStatEntity playerStat = playerStatRepository
                    .findByPlayerIdAndStatCode(playerId, questStat.getStatCode())
                    .orElseGet(() -> {
                        PlayerStatEntity created = new PlayerStatEntity();
                        created.setPlayerId(playerId);
                        created.setStatCode(questStat.getStatCode());
                        created.setStatName(questStat.getStatName());
                        created.setCurrentValue(1);
                        created.setCurrentXp(0);
                        return created;
                    });

            int addedValue = questStat.getStatPointsReward();
            int addedXp = xpAwarded;

            playerStat.setCurrentValue(playerStat.getCurrentValue() + addedValue);
            playerStat.setCurrentXp(playerStat.getCurrentXp() + addedXp);
            playerStatRepository.save(playerStat);

            statChanges.add(new StatChangeDto(
                    playerStat.getStatCode(),
                    playerStat.getStatName(),
                    addedValue,
                    playerStat.getCurrentValue(),
                    addedXp,
                    playerStat.getCurrentXp()
            ));
        }

        QuestCompletionEntity completion = new QuestCompletionEntity();
        completion.setPlayerId(playerId);
        completion.setQuestId(taskId);
        completion.setCompletionDate(today);
        completion.setXpAwarded(xpAwarded);

        try {
            questCompletionRepository.saveAndFlush(completion);
        } catch (DataIntegrityViolationException exception) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Задание уже выполнено сегодня");
        }

        return new CompleteTaskResponse(
                quest.getId(),
                quest.getTitle(),
                xpAwarded,
                totalXp,
                newLevel,
                oldLevel,
                newLevel,
                newLevel > oldLevel,
                player.getCurrentStreak(),
                CharacterFormulaHelper.calculateNextLevelXp(newLevel),
                CharacterFormulaHelper.calculateXpIntoLevel(totalXp, newLevel),
                CharacterFormulaHelper.calculateXpForNextLevel(newLevel),
                CharacterFormulaHelper.calculateProgressPercent(totalXp, newLevel),
                statChanges
        );
    }

    private void updateStreak(PlayerEntity player, LocalDate today) {
        LocalDate lastActiveDate = player.getLastActiveDate();
        int currentStreak = player.getCurrentStreak() == null ? 0 : player.getCurrentStreak();

        if (lastActiveDate == null || lastActiveDate.isBefore(today.minusDays(1))) {
            player.setCurrentStreak(1);
        } else if (lastActiveDate.equals(today.minusDays(1))) {
            player.setCurrentStreak(currentStreak + 1);
        } else {
            player.setCurrentStreak(currentStreak);
        }

        player.setLastActiveDate(today);
    }
}
