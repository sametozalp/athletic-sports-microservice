package com.ozalp.training_program.business.mappers;

import com.ozalp.training_program.business.dtos.requests.CreateTrainingProgramRequest;
import com.ozalp.training_program.business.dtos.responses.TrainingProgramResponse;
import com.ozalp.training_program.models.entities.TrainingProgram;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingProgramMapper {

    TrainingProgramResponse toResponse(TrainingProgram trainingProgram);
    TrainingProgram toEntity(CreateTrainingProgramRequest request);
}
