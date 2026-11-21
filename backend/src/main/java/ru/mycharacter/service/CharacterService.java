package ru.mycharacter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ru.mycharacter.api.models.BranchProgressDto;
import ru.mycharacter.api.models.CharacterProfileResponse;
import ru.mycharacter.api.models.PlayerStatDto;
import ru.mycharacter.entity.PlayerEntity;
import ru.mycharacter.helper.CharacterFormulaHelper;
import ru.mycharacter.repository.PlayerBranchRepository;
import ru.mycharacter.repository.PlayerRepository;
import ru.mycharacter.repository.PlayerStatRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final PlayerRepository playerRepository;
    private final PlayerStatRepository playerStatRepository;
    private final PlayerBranchRepository playerBranchRepository;

    @Transactional(readOnly = true)
    public CharacterProfileResponse getCharacterProfile(Long playerId) {
        PlayerEntity player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found"));

        List<PlayerStatDto> stats = playerStatRepository.findByPlayerId(playerId)
                .stream()
                .map(stat -> {
                    PlayerStatDto dto = new PlayerStatDto();
                    dto.setStatCode(stat.getStatCode());
                    dto.setStatName(stat.getStatName());
                    dto.setCurrentValue(stat.getCurrentValue());
                    dto.setCurrentXp(stat.getCurrentXp());
                    return dto;
                })
                .toList();

        List<BranchProgressDto> branches = playerBranchRepository.findByPlayerId(playerId)
                .stream()
                .map(pb -> {
                    BranchProgressDto dto = new BranchProgressDto();
                    dto.setBranchId(pb.getBranch().getId());
                    dto.setCode(pb.getBranch().getCode());
                    dto.setName(pb.getBranch().getName());
                    dto.setBranchLevel(pb.getBranchLevel());
                    dto.setBranchXp(pb.getBranchXp());
                    return dto;
                })
                .toList();

        int level = player.getLevel();
        int totalXp = player.getTotalXp();

        CharacterProfileResponse response = new CharacterProfileResponse();
        response.setId(player.getId());
        response.setNickname(player.getNickname());
        response.setCharacterName(player.getCharacterName());
        response.setLevel(level);
        response.setTotalXp(totalXp);
        response.setNextLevelXp(CharacterFormulaHelper.calculateNextLevelXp(level));
        response.setXpIntoLevel(CharacterFormulaHelper.calculateXpIntoLevel(totalXp, level));
        response.setXpForNextLevel(CharacterFormulaHelper.calculateXpForNextLevel(level));
        response.setProgressPercent(CharacterFormulaHelper.calculateProgressPercent(totalXp, level));
        response.setCurrentStreak(player.getCurrentStreak());
        response.setStats(stats);
        response.setSelectedBranches(branches);
        return response;
    }
}
