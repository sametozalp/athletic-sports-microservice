package com.ozalp.training_program.models.entities;

import com.ozalp.training_program.models.enums.MealType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "meal_item_tasks")
@Getter
@Setter
@NoArgsConstructor
public class MealItemTask extends TrainingItemTask {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MealType mealType;

    @Column
    private int calories;
}