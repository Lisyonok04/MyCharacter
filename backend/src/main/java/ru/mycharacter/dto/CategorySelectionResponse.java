package ru.mycharacter.dto;

import ru.mycharacter.api.models.BranchProgressDto;

import java.util.List;

public record CategorySelectionResponse(Long playerId, List<BranchProgressDto> selectedBranches) {
}
