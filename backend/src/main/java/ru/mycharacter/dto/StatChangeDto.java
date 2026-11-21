package ru.mycharacter.dto;

public record StatChangeDto(
        String statCode,
        String statName,
        Integer addedValue,
        Integer newValue,
        Integer addedXp,
        Integer newXp
) {
}
