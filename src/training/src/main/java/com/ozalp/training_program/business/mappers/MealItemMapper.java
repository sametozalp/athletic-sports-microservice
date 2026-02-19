package com.ozalp.training_program.business.mappers;

import com.ozalp.training_program.business.dtos.requests.CreateMealItemTaskRequest;
import com.ozalp.training_program.business.dtos.responses.MealItemResponse;
import com.ozalp.training_program.models.entities.MealItemTask;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MealItemMapper {

    MealItemTask toEntity(CreateMealItemTaskRequest request);

    MealItemResponse toResponse(MealItemTask mealItemTask);
}
