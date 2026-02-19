package com.ozalp.training.dataAccess;

import com.ozalp.training.models.entities.MealItemTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealItemRepository extends JpaRepository<MealItemTask, Integer> {
}
