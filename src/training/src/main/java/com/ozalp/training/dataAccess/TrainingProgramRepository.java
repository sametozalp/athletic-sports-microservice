package com.ozalp.training.dataAccess;

import com.ozalp.training.models.entities.TrainingProgram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingProgramRepository extends JpaRepository<TrainingProgram, Integer> {
}
