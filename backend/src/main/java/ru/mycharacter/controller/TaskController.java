package ru.mycharacter.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mycharacter.dto.CompleteTaskRequest;
import ru.mycharacter.dto.CompleteTaskResponse;
import ru.mycharacter.dto.TaskListResponse;
import ru.mycharacter.service.TaskService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<TaskListResponse> getTasks(
            @RequestParam Long playerId,
            @RequestParam(required = false) Long branchId
    ) {
        return ResponseEntity.ok(taskService.getTasks(playerId, branchId));
    }

    @PostMapping("/tasks/{id}/complete")
    public ResponseEntity<CompleteTaskResponse> completeTask(
            @PathVariable Long id,
            @Valid @RequestBody CompleteTaskRequest request
    ) {
        return ResponseEntity.ok(taskService.completeTask(id, request.playerId()));
    }
}
