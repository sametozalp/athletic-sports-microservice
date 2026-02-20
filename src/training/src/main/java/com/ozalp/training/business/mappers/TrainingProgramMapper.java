package com.ozalp.training.business.mappers;

import com.ozalp.training.business.dtos.requests.CreateTrainingProgramRequest;
import com.ozalp.training.business.dtos.responses.TrainingProgramResponse;
import com.ozalp.training.business.dtos.responses.UserProfile;
import com.ozalp.training.models.entities.TrainingProgram;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TrainingProgramMapper {

    @Mapping(target = "id", source = "trainingProgram.id")
    @Mapping(target = "athlete", source = "athlete")
    @Mapping(target = "coach", source = "coach")
    TrainingProgramResponse toResponse(TrainingProgram trainingProgram, UserProfile athlete, UserProfile coach);
    TrainingProgram toEntity(CreateTrainingProgramRequest request);
}
