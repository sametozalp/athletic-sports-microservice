package com.ozalp.training.dataAccess;

import com.ozalp.training.models.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
}
