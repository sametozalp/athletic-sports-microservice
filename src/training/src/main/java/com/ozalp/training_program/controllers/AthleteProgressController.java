package com.ozalp.training_program.controllers;

import com.ozalp.training_program.business.dtos.requests.CreateAthleteProgressRequest;
import com.ozalp.training_program.business.services.AthleteProgressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/athleteProgress")
@RequiredArgsConstructor
public class AthleteProgressController {

    private final AthleteProgressService athleteProgressService;

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody @Valid CreateAthleteProgressRequest request) {
        return ResponseEntity.ok(athleteProgressService.create(request));
    }
}
