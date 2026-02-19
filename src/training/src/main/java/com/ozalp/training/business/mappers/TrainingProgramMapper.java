package com.ozalp.training.business.mappers;

import com.ozalp.training.business.dtos.requests.CreateTrainingProgramRequest;
import com.ozalp.training.business.dtos.responses.TrainingProgramResponse;
import com.ozalp.training.models.entities.TrainingProgram;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingProgramMapper {

    TrainingProgramResponse toResponse(TrainingProgram trainingProgram);
    TrainingProgram toEntity(CreateTrainingProgramRequest request);
}
