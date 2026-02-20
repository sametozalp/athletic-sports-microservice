package com.ozalp.training.controllers;

import com.ozalp.training.business.dtos.requests.CreateMealItemTaskRequest;
import com.ozalp.training.business.services.MealItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ozalp.utils.consts.ApiConst;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConst.ApiPath.MEAL_ITEM_TASK)
@RequiredArgsConstructor
public class MealItemController {

    private final MealItemService mealItemService;

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody @Valid CreateMealItemTaskRequest request) {
        return ResponseEntity.ok(mealItemService.create(request));
    }
}
