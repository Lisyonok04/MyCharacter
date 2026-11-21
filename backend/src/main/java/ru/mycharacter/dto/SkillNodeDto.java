package ru.mycharacter.dto;

import java.util.List;

public record SkillNodeDto(
        Long id,
        Long branchId,
        String branchCode,
        String branchName,
        String code,
        String name,
        String description,
        Integer requiredBranchLevel,
        Integer requiredPlayerLevel,
        SkillStatus status,
        List<Long> dependencies,
        Integer sortOrder
) {
}
