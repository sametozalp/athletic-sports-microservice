package com.ozalp.training.business.services;

import com.ozalp.training.business.dtos.requests.CreateTrainingProgramRequest;
import com.ozalp.training.business.dtos.responses.TrainingProgramResponse;
import com.ozalp.training.models.entities.TrainingProgram;
import org.ozalp.services.BaseService;

public interface TrainingProgramService extends BaseService<TrainingProgram> {

    TrainingProgramResponse create(CreateTrainingProgramRequest request);

}
