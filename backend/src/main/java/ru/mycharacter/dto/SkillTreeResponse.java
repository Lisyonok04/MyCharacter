package ru.mycharacter.dto;

import java.util.List;

public record SkillTreeResponse(List<SkillNodeDto> nodes) {
}
