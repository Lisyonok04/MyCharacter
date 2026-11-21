package ru.mycharacter.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mycharacter.dto.CategoryListResponse;
import ru.mycharacter.dto.CategorySelectionRequest;
import ru.mycharacter.dto.CategorySelectionResponse;
import ru.mycharacter.service.CategoryService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<CategoryListResponse> getAvailableCategories(
            @RequestParam(required = false) Long playerId
    ) {
        return ResponseEntity.ok(categoryService.getAvailableCategories(playerId));
    }

    @PostMapping("/character/categories")
    public ResponseEntity<CategorySelectionResponse> selectCategories(
            @Valid @RequestBody CategorySelectionRequest request
    ) {
        return ResponseEntity.ok(categoryService.selectCategories(request));
    }
}
