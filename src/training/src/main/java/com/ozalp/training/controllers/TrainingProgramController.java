package com.ozalp.training.controllers;

import com.ozalp.training.business.dtos.requests.CreateTrainingProgramRequest;
import com.ozalp.training.business.services.TrainingProgramService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trainingProgram")
@RequiredArgsConstructor
public class TrainingProgramController {

    private final TrainingProgramService trainingProgramService;

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody @Valid CreateTrainingProgramRequest request) {
        return ResponseEntity.ok(trainingProgramService.create(request));
    }
}
