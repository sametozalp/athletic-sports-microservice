package com.ozalp.training.business.services;

import com.ozalp.training.business.dtos.requests.CreateMealItemTaskRequest;
import com.ozalp.training.business.dtos.responses.MealItemResponse;
import com.ozalp.training.models.entities.MealItemTask;
import org.ozalp.services.BaseService;

public interface MealItemService extends BaseService<MealItemTask> {

    MealItemResponse create(CreateMealItemTaskRequest request);
}
