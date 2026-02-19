package com.ozalp.training_program.controllers;

import com.ozalp.training_program.business.dtos.requests.CreateMealItemTaskRequest;
import com.ozalp.training_program.business.services.MealItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mealItemTask")
@RequiredArgsConstructor
public class MealItemController {

    private final MealItemService mealItemService;

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody @Valid CreateMealItemTaskRequest request) {
        return ResponseEntity.ok(mealItemService.create(request));
    }
}
