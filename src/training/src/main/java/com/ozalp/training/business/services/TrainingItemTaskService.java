package com.ozalp.training.business.services;

import com.ozalp.training.business.dtos.responses.TrainingItemTaskResponse;
import com.ozalp.training.models.entities.TrainingItemTask;

import java.util.List;

public interface TrainingItemTaskService extends BaseService<TrainingItemTask> {

    List<TrainingItemTaskResponse> getAll();
}
