package com.ozalp.training_program.business.services;

import com.ozalp.training_program.business.dtos.responses.TrainingItemTaskResponse;
import com.ozalp.training_program.models.entities.TrainingItemTask;

import java.util.List;

public interface TrainingItemTaskService extends BaseService<TrainingItemTask> {

    List<TrainingItemTaskResponse> getAll();
}
