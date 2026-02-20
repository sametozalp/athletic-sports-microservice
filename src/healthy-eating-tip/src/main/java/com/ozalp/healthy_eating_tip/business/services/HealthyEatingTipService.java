package com.ozalp.healthy_eating_tip.business.services;

import com.ozalp.healthy_eating_tip.business.dtos.requests.CreateHealthyEatingTipRequest;
import com.ozalp.healthy_eating_tip.business.dtos.responses.HealthyEatingTipResponse;
import com.ozalp.healthy_eating_tip.models.entities.HealthyEatingTip;
import org.ozalp.services.BaseService;

public interface HealthyEatingTipService extends BaseService<HealthyEatingTip> {

    HealthyEatingTipResponse create(CreateHealthyEatingTipRequest request);

    HealthyEatingTipResponse getRandomTip();

}
