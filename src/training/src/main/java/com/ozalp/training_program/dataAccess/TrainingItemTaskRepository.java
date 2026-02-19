package com.ozalp.training_program.dataAccess;

import com.ozalp.training_program.models.entities.TrainingItemTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingItemTaskRepository extends JpaRepository<TrainingItemTask, Integer> {
}
