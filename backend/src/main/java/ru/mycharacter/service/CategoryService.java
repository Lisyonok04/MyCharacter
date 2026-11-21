package ru.mycharacter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ru.mycharacter.api.models.BranchProgressDto;
import ru.mycharacter.dto.CategoryDto;
import ru.mycharacter.dto.CategoryListResponse;
import ru.mycharacter.dto.CategorySelectionRequest;
import ru.mycharacter.dto.CategorySelectionResponse;
import ru.mycharacter.entity.DevelopmentBranchEntity;
import ru.mycharacter.entity.PlayerBranchEntity;
import ru.mycharacter.repository.DevelopmentBranchRepository;
import ru.mycharacter.repository.PlayerBranchRepository;
import ru.mycharacter.repository.PlayerRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private static final int MAX_CATEGORIES = 3;

    private final PlayerRepository playerRepository;
    private final DevelopmentBranchRepository branchRepository;
    private final PlayerBranchRepository playerBranchRepository;

    @Transactional(readOnly = true)
    public CategoryListResponse getAvailableCategories(Long playerId) {
        Set<Long> selectedIds = playerId == null
                ? Set.of()
                : playerBranchRepository.findByPlayerId(playerId).stream()
                .map(pb -> pb.getBranch().getId())
                .collect(Collectors.toSet());

        List<CategoryDto> categories = branchRepository.findActiveBranches().stream()
                .map(branch -> new CategoryDto(
                        branch.getId(),
                        branch.getCode(),
                        branch.getName(),
                        branch.getDescription(),
                        selectedIds.contains(branch.getId())
                ))
                .toList();

        return new CategoryListResponse(categories);
    }

    @Transactional
    public CategorySelectionResponse selectCategories(CategorySelectionRequest request) {
        Long playerId = request.playerId();
        if (!playerRepository.existsById(playerId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found");
        }

        List<Long> branchIds = request.branchIds();
        if (branchIds == null || branchIds.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Нужно выбрать хотя бы одну категорию");
        }
        if (branchIds.size() > MAX_CATEGORIES) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Можно выбрать не более " + MAX_CATEGORIES + " категорий"
            );
        }
        if (new HashSet<>(branchIds).size() != branchIds.size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Категории не должны повторяться");
        }

        List<DevelopmentBranchEntity> branches = branchRepository.findActiveByIds(branchIds);
        if (branches.size() != branchIds.size()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Некоторые категории не найдены или недоступны"
            );
        }

        playerBranchRepository.deleteByPlayerIdAndBranchIdNotIn(playerId, branchIds);

        for (DevelopmentBranchEntity branch : branches) {
            if (playerBranchRepository.findByPlayerIdAndBranchId(playerId, branch.getId()).isEmpty()) {
                PlayerBranchEntity playerBranch = new PlayerBranchEntity();
                playerBranch.setPlayerId(playerId);
                playerBranch.setBranch(branch);
                playerBranch.setBranchLevel(1);
                playerBranch.setBranchXp(0);
                playerBranchRepository.save(playerBranch);
            }
        }

        List<BranchProgressDto> selectedBranches = playerBranchRepository.findByPlayerId(playerId).stream()
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

        return new CategorySelectionResponse(playerId, selectedBranches);
    }
}
