package com.ozalp.training_program.business.dtos.responses;

import com.ozalp.training_program.models.enums.AthleteProgressStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AthleteProgressResponse {

    private int id;

    private TrainingItemTaskResponse trainingItemTask;

    private AthleteProgressStatus status;

    private LocalDateTime completedAt;

    private int pointsEarned;

//    private OrganizationResponse organization;

}
