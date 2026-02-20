package com.ozalp.training.controllers;

import com.ozalp.training.business.services.TrainingItemTaskService;
import lombok.RequiredArgsConstructor;
import org.ozalp.utils.consts.ApiConst;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConst.ApiPath.TRAINING_ITEM_TASK)
@RequiredArgsConstructor
public class TrainingItemController {

    private final TrainingItemTaskService trainingItemTaskService;

    @PostMapping("/getAll")
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(trainingItemTaskService.getAll());
    }
}
