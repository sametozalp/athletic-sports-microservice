package com.ozalp.healthy_eating_tip.controllers;

import com.ozalp.healthy_eating_tip.business.dtos.requests.CreateHealthyEatingTipRequest;
import com.ozalp.healthy_eating_tip.business.services.HealthyEatingTipService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/healthyEatingTip")
@RequiredArgsConstructor
public class HealthyEatingTipController {

    private final HealthyEatingTipService healthyEatingTipService;

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody @Valid CreateHealthyEatingTipRequest request) {
        return ResponseEntity.ok(healthyEatingTipService.create(request));
    }

    @GetMapping("/random")
    ResponseEntity<?> getRandom() {
        return ResponseEntity.ok(healthyEatingTipService.getRandomTip());
    }
}
