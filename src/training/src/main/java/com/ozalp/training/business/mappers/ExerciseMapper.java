package com.ozalp.training.business.mappers;

import com.ozalp.training.business.dtos.requests.CreateExerciseRequest;
import com.ozalp.training.business.dtos.responses.ExerciseResponse;
import com.ozalp.training.models.entities.Exercise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {

    Exercise toEntity(CreateExerciseRequest request);
    ExerciseResponse toResponse(Exercise exercise);
}
