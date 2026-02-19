package com.ozalp.training_program.dataAccess;

import com.ozalp.training_program.models.entities.MealItemTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealItemRepository extends JpaRepository<MealItemTask, Integer> {
}
