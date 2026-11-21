package ru.mycharacter.dto;

public record TaskDto(
        Long id,
        Long branchId,
        String branchCode,
        String branchName,
        String title,
        String description,
        Integer difficulty,
        Integer baseXp,
        boolean completedToday
) {
}
