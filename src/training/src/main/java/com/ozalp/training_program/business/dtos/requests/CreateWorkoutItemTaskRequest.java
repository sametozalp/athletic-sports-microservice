package com.ozalp.training_program.business.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateWorkoutItemTaskRequest {

    private int trainingProgramId;

    private LocalDate date;

    private String coachNote;

    private int exerciseId;

    private int sets;

    private int reps;

}
