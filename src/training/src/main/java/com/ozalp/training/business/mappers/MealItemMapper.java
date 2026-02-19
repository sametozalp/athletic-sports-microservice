package com.ozalp.training.business.mappers;

import com.ozalp.training.business.dtos.requests.CreateMealItemTaskRequest;
import com.ozalp.training.business.dtos.responses.MealItemResponse;
import com.ozalp.training.models.entities.MealItemTask;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MealItemMapper {

    MealItemTask toEntity(CreateMealItemTaskRequest request);

    MealItemResponse toResponse(MealItemTask mealItemTask);
}
