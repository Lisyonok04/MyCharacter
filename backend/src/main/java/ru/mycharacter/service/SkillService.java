package ru.mycharacter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ru.mycharacter.dto.SkillNodeDto;
import ru.mycharacter.dto.SkillStatus;
import ru.mycharacter.dto.SkillTreeResponse;
import ru.mycharacter.entity.PlayerEntity;
import ru.mycharacter.entity.SkillNodeDependencyEntity;
import ru.mycharacter.entity.SkillNodeEntity;
import ru.mycharacter.repository.PlayerBranchRepository;
import ru.mycharacter.repository.PlayerRepository;
import ru.mycharacter.repository.SkillNodeDependencyRepository;
import ru.mycharacter.repository.SkillNodeRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final PlayerRepository playerRepository;
    private final PlayerBranchRepository playerBranchRepository;
    private final SkillNodeRepository skillNodeRepository;
    private final SkillNodeDependencyRepository skillNodeDependencyRepository;

    @Transactional(readOnly = true)
    public SkillTreeResponse getSkillTree(Long playerId) {
        PlayerEntity player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found"));

        Map<Long, Integer> branchLevels = playerBranchRepository.findByPlayerId(playerId).stream()
                .collect(Collectors.toMap(
                        pb -> pb.getBranch().getId(),
                        pb -> pb.getBranchLevel()
                ));

        List<SkillNodeEntity> nodes = skillNodeRepository.findAllWithBranch();
        Map<Long, SkillNodeEntity> nodesById = nodes.stream()
                .collect(Collectors.toMap(SkillNodeEntity::getId, Function.identity()));

        Map<Long, List<Long>> dependencies = new HashMap<>();
        for (SkillNodeDependencyEntity dependency : skillNodeDependencyRepository.findAll()) {
            dependencies
                    .computeIfAbsent(dependency.getId().getNodeId(), key -> new ArrayList<>())
                    .add(dependency.getId().getDependsOnNodeId());
        }

        Map<Long, Boolean> unlockedCache = new HashMap<>();
        List<SkillNodeDto> result = nodes.stream()
                .map(node -> {
                    List<Long> nodeDependencies = dependencies.getOrDefault(node.getId(), List.of());
                    boolean dependenciesUnlocked = nodeDependencies.stream()
                            .allMatch(dependencyId -> isUnlocked(
                                    dependencyId,
                                    nodesById,
                                    dependencies,
                                    branchLevels,
                                    player.getLevel(),
                                    unlockedCache,
                                    new HashSet<>()
                            ));

                    int branchLevel = branchLevels.getOrDefault(node.getBranch().getId(), 0);
                    boolean levelRequirementMet = branchLevel >= node.getRequiredBranchLevel()
                            && player.getLevel() >= node.getRequiredPlayerLevel();
                    boolean unlocked = dependenciesUnlocked && levelRequirementMet;

                    SkillStatus status;
                    if (unlocked) {
                        status = SkillStatus.UNLOCKED;
                    } else if (dependenciesUnlocked) {
                        status = SkillStatus.AVAILABLE;
                    } else {
                        status = SkillStatus.LOCKED;
                    }

                    return new SkillNodeDto(
                            node.getId(),
                            node.getBranch().getId(),
                            node.getBranch().getCode(),
                            node.getBranch().getName(),
                            node.getCode(),
                            node.getName(),
                            node.getDescription(),
                            node.getRequiredBranchLevel(),
                            node.getRequiredPlayerLevel(),
                            status,
                            nodeDependencies,
                            node.getSortOrder()
                    );
                })
                .toList();

        return new SkillTreeResponse(result);
    }

    private boolean isUnlocked(
            Long nodeId,
            Map<Long, SkillNodeEntity> nodesById,
            Map<Long, List<Long>> dependencies,
            Map<Long, Integer> branchLevels,
            int playerLevel,
            Map<Long, Boolean> cache,
            Set<Long> visiting
    ) {
        if (cache.containsKey(nodeId)) {
            return cache.get(nodeId);
        }
        if (!visiting.add(nodeId)) {
            return false;
        }

        SkillNodeEntity node = nodesById.get(nodeId);
        boolean unlocked = false;

        if (node != null) {
            boolean dependenciesUnlocked = dependencies.getOrDefault(nodeId, List.of()).stream()
                    .allMatch(dependencyId -> isUnlocked(
                            dependencyId,
                            nodesById,
                            dependencies,
                            branchLevels,
                            playerLevel,
                            cache,
                            visiting
                    ));

            int branchLevel = branchLevels.getOrDefault(node.getBranch().getId(), 0);
            boolean levelRequirementMet = branchLevel >= node.getRequiredBranchLevel()
                    && playerLevel >= node.getRequiredPlayerLevel();

            unlocked = dependenciesUnlocked && levelRequirementMet;
        }

        visiting.remove(nodeId);
        cache.put(nodeId, unlocked);
        return unlocked;
    }
}
