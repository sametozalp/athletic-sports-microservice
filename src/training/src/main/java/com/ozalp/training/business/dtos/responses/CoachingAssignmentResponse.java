package com.ozalp.training.business.dtos.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CoachingAssignmentResponse {

    private int id;
    private UserProfile athleteUserProfile;
    private UserProfile coachUserProfile;
}
