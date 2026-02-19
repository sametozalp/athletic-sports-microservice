package com.ozalp.training_program.business.services;

import com.ozalp.training_program.business.dtos.requests.CreateTrainingProgramRequest;
import com.ozalp.training_program.business.dtos.responses.TrainingProgramResponse;
import com.ozalp.training_program.models.entities.TrainingProgram;

public interface TrainingProgramService extends BaseService<TrainingProgram> {

    TrainingProgramResponse create(CreateTrainingProgramRequest request);

}
