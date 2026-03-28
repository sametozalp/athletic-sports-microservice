package com.ozalp.auth.business.impls;

import com.ozalp.auth.business.dtos.requests.UpdateProfileRequest;
import com.ozalp.auth.business.dtos.responses.UserProfileResponse;
import com.ozalp.auth.business.mappers.UserProfileMapper;
import com.ozalp.auth.business.services.UserProfileService;
import com.ozalp.auth.dataAccess.UserProfileRepository;
import com.ozalp.auth.models.entities.UserProfile;
import lombok.RequiredArgsConstructor;
import org.ozalp.managers.BaseImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileImpl extends BaseImpl<UserProfile> implements UserProfileService {

    private final UserProfileRepository repository;
    private final UserProfileMapper mapper;

    @Override
    protected JpaRepository<UserProfile, Integer> getRepository() {
        return repository;
    }

    @Override
    public UserProfileResponse updateProfile(UpdateProfileRequest request) {
        UserProfile profile = findById(request.getProfileId());
        mapper.updateEntity(request, profile);
        return mapper.toResponse(repository.save(profile));
    }

    @Override
    public UserProfileResponse getProfileDetail(int id) {
        return mapper.toResponse(findById(id));
    }
}
