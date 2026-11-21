package ru.mycharacter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mycharacter.dto.SkillTreeResponse;
import ru.mycharacter.service.SkillService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @GetMapping("/skills")
    public ResponseEntity<SkillTreeResponse> getSkillTree(@RequestParam Long playerId) {
        return ResponseEntity.ok(skillService.getSkillTree(playerId));
    }
}
