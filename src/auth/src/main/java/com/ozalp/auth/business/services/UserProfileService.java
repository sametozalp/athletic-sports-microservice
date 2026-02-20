package com.ozalp.auth.business.services;

import com.ozalp.auth.business.dtos.requests.UpdateProfileRequest;
import com.ozalp.auth.business.dtos.responses.UserProfileResponse;
import com.ozalp.auth.models.entities.UserProfile;
import org.ozalp.services.BaseService;

public interface UserProfileService extends BaseService<UserProfile> {

    UserProfileResponse updateProfile(UpdateProfileRequest request);

    UserProfileResponse getProfileDetail(int id);
}
