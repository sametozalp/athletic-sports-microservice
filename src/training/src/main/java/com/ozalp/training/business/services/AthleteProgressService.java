package com.ozalp.training.business.services;


import com.ozalp.training.business.dtos.requests.CreateAthleteProgressRequest;
import com.ozalp.training.business.dtos.responses.AthleteProgressResponse;
import com.ozalp.training.models.entities.AthleteProgress;

import java.util.List;

public interface AthleteProgressService extends BaseService<AthleteProgress> {

    AthleteProgressResponse create(CreateAthleteProgressRequest request);

    int getTotalPointThisMonth(int userProfileId);

    int getAchievementPercentageThisMonth(int userProfile);

    List<AthleteProgressResponse> getDailyMissions(int userProfileId);

}
