package com.ozalp.training_program.business.services;


import com.ozalp.training_program.business.dtos.requests.CreateAthleteProgressRequest;
import com.ozalp.training_program.business.dtos.responses.AthleteProgressResponse;
import com.ozalp.training_program.models.entities.AthleteProgress;

import java.util.List;

public interface AthleteProgressService extends BaseService<AthleteProgress> {

    AthleteProgressResponse create(CreateAthleteProgressRequest request);

    int getTotalPointThisMonth(int userProfileId);

    int getAchievementPercentageThisMonth(int userProfile);

    List<AthleteProgressResponse> getDailyMissions(int userProfileId);

}
