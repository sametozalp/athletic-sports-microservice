package com.ozalp.training_program.business.dtos.responses;

import com.ozalp.training_program.models.enums.MealType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MealItemResponse {

    private int id;

    private MealType mealType;

    private int calories;
}
