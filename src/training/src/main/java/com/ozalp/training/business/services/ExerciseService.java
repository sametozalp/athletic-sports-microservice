package com.ozalp.training.business.services;

import com.ozalp.training.business.dtos.requests.CreateExerciseRequest;
import com.ozalp.training.business.dtos.responses.ExerciseResponse;
import com.ozalp.training.models.entities.Exercise;

public interface ExerciseService extends BaseService<Exercise> {

    ExerciseResponse create(CreateExerciseRequest request);
}
