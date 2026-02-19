package com.ozalp.training.business.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCoachingAssignmentRequest {

    private int athleteUserProfileId;
    private int coachUserProfileId;
}
