package com.ozalp.training_program.business.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TrainingProgramResponse {

    private int id;

//    private UserProfileResponse coach;
//
//    private UserProfileResponse athlete;

    private String title;

    private String description;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

}
