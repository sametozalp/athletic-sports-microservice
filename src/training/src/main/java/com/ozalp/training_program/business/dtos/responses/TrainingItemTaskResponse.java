package com.ozalp.training_program.business.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TrainingItemTaskResponse {

    private int id;

    private int point;

    private LocalDate date;

    private String coachNote;
}
