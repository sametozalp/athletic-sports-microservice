package com.ozalp.training.controllers;

import com.ozalp.training.business.dtos.requests.CreateCoachingAssignmentRequest;
import com.ozalp.training.business.services.CoachingAssignmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ozalp.utils.consts.ApiConst;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConst.ApiPath.COACHING_ASSIGNMENT)
@RequiredArgsConstructor
public class CoachingAssignmentController {

    private final CoachingAssignmentService coachingAssignmentService;

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody @Valid CreateCoachingAssignmentRequest request) {
        coachingAssignmentService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable int id) {
        coachingAssignmentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }
}
