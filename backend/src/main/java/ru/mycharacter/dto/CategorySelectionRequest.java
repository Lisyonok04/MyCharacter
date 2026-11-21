package ru.mycharacter.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CategorySelectionRequest(
        @NotNull Long playerId,
        @NotNull @Size(min = 1, max = 3, message = "Нужно выбрать от 1 до 3 категорий") List<@NotNull Long> branchIds
) {
}
