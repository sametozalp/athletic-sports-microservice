package com.ozalp.training.dataAccess;

import com.ozalp.training.models.entities.TrainingItemTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingItemTaskRepository extends JpaRepository<TrainingItemTask, Integer> {
}
