package com.ozalp.training_program.controllers;

import com.ozalp.training_program.business.services.TrainingItemTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trainingItemTask")
@RequiredArgsConstructor
public class TrainingItemController {

    private final TrainingItemTaskService trainingItemTaskService;

    @PostMapping("/getAll")
    ResponseEntity<?> getAll() {
        return ResponseEntity.ok(trainingItemTaskService.getAll());
    }
}
