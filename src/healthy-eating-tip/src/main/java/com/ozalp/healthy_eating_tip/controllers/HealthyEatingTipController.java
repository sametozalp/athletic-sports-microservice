package com.ozalp.healthy_eating_tip.controllers;

import com.ozalp.healthy_eating_tip.business.dtos.requests.CreateHealthyEatingTipRequest;
import com.ozalp.healthy_eating_tip.business.services.HealthyEatingTipService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ozalp.utils.consts.ApiConst;
import org.ozalp.utils.consts.ApiParams;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConst.ApiPath.HEALTHY_EATING_TIP)
@RequiredArgsConstructor
public class HealthyEatingTipController {

    private final HealthyEatingTipService healthyEatingTipService;

    @PostMapping(ApiParams.HealthyEatingTip.CREATE)
    ResponseEntity<?> create(@RequestBody @Valid CreateHealthyEatingTipRequest request) {
        return ResponseEntity.ok(healthyEatingTipService.create(request));
    }

    @GetMapping(ApiParams.HealthyEatingTip.RANDOM)
    ResponseEntity<?> getRandom() {
        return ResponseEntity.ok(healthyEatingTipService.getRandomTip());
    }
}
