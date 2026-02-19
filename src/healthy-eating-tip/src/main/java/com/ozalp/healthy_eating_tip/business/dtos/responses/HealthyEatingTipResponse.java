package com.ozalp.healthy_eating_tip.business.dtos.responses;

import com.ozalp.healthy_eating_tip.models.enums.Icon;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HealthyEatingTipResponse {
    private String title;
    private String description;
    private Icon icon;
}
