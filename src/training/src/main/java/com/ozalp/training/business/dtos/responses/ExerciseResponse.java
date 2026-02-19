package com.ozalp.training.business.dtos.responses;

import com.ozalp.training.models.enums.MuscleGroup;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ExerciseResponse {

    private int id;

    private String name;

    private String description;

    private List<MuscleGroup> muscleGroup;

    private int point;
}
