package com.ozalp.training_program.business.mappers;

import com.ozalp.training_program.business.dtos.responses.TrainingItemTaskResponse;
import com.ozalp.training_program.models.entities.TrainingItemTask;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingItemMapper {

    TrainingItemTaskResponse toResponse(TrainingItemTask trainingItemTask);
}
