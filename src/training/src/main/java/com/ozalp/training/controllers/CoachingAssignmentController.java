package com.ozalp.training.controllers;

import com.ozalp.training.business.dtos.requests.CreateCoachingAssignmentRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coachingAssignment")
@RequiredArgsConstructor
public class CoachingAssignmentController {

    private final CoachingAssignmentController coachingAssignmentController;

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody @Valid CreateCoachingAssignmentRequest request) {
        coachingAssignmentController.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable int id) {
        coachingAssignmentController.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }
}
