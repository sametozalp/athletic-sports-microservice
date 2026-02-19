package com.ozalp.training.business.dtos.responses;

import com.ozalp.training.models.enums.AthleteProgressStatus;
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

    private Organization organization;

}
