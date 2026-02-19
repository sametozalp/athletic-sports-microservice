package com.ozalp.healthy_eating_tip.business.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateHealthyEatingTipRequest {
    private String title;
    private String description;
}