package com.ozalp.training_program.business.services;

import com.ozalp.training_program.business.dtos.requests.CreateMealItemTaskRequest;
import com.ozalp.training_program.business.dtos.responses.MealItemResponse;
import com.ozalp.training_program.models.entities.MealItemTask;

public interface MealItemService extends BaseService<MealItemTask> {

    MealItemResponse create(CreateMealItemTaskRequest request);
}
