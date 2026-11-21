package ru.mycharacter.dto;

import java.util.List;

public record TaskListResponse(List<TaskDto> tasks) {
}
