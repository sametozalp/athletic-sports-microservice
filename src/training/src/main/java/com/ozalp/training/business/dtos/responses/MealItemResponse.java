package com.ozalp.training.business.dtos.responses;

import com.ozalp.training.models.enums.MealType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MealItemResponse {

    private int id;

    private MealType mealType;

    private int calories;
}
