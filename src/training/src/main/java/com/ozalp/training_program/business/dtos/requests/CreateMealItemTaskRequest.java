package com.ozalp.training_program.business.dtos.requests;

import com.ozalp.training_program.models.enums.MealType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateMealItemTaskRequest {

    private int trainingProgramId;

    private LocalDate date;

    private String coachNote;

    private MealType mealType;

    private int calories;
}
