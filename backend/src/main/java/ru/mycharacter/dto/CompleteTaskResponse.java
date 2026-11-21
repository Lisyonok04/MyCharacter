package ru.mycharacter.dto;

import java.util.List;

public record CompleteTaskResponse(
        Long taskId,
        String taskTitle,
        Integer xpAwarded,
        Integer totalXp,
        Integer level,
        Integer oldLevel,
        Integer newLevel,
        boolean levelUp,
        Integer currentStreak,
        Integer nextLevelXp,
        Integer xpIntoLevel,
        Integer xpForNextLevel,
        Integer progressPercent,
        List<StatChangeDto> statChanges
) {
}
