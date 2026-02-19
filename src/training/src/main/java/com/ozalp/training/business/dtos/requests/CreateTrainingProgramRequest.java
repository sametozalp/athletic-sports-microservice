package com.ozalp.training.business.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateTrainingProgramRequest {

    private int coachUserProfileId;

    private int athleteUserProfileId;

    private String title;

    private String description;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

}
