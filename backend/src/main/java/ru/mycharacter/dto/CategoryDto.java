package ru.mycharacter.dto;

public record CategoryDto(
        Long branchId,
        String code,
        String name,
        String description,
        boolean selected
) {
}
