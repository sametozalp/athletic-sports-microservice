package com.ozalp.training_program.dataAccess;

import com.ozalp.training_program.models.entities.TrainingProgram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingProgramRepository extends JpaRepository<TrainingProgram, Integer> {
}
