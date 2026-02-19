package com.ozalp.training.business.mappers;

import com.ozalp.training.business.dtos.responses.TrainingItemTaskResponse;
import com.ozalp.training.models.entities.TrainingItemTask;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrainingItemMapper {

    TrainingItemTaskResponse toResponse(TrainingItemTask trainingItemTask);
}
