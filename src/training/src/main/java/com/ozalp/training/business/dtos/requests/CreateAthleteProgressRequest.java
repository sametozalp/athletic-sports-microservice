package com.ozalp.training.business.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateAthleteProgressRequest {

    private int trainingItemId;

    private LocalDateTime completedAt;

    private int organizationId;

}
