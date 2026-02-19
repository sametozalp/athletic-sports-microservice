package com.ozalp.motivation_sentence.controllers;

import com.ozalp.motivation_sentence.business.dtos.CreateMotivationSentenceRequest;
import com.ozalp.motivation_sentence.business.services.MotivationSentenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/motivationSentence")
@RequiredArgsConstructor
public class MotivationSentenceController {

    private final MotivationSentenceService motivationSentenceService;

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody @Valid CreateMotivationSentenceRequest request) {
        return ResponseEntity.ok(motivationSentenceService.create(request));
    }

    @GetMapping("/random")
    ResponseEntity<?> getRandom() {
        return ResponseEntity.ok(motivationSentenceService.getRandomSentence());
    }
}
