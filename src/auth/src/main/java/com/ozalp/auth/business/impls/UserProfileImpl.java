package com.ozalp.auth.business.impls;

import com.ozalp.auth.business.dtos.requests.UpdateProfileRequest;
import com.ozalp.auth.business.dtos.responses.UserProfileResponse;
import com.ozalp.auth.business.mappers.UserProfileMapper;
import com.ozalp.auth.business.services.UserProfileService;
import com.ozalp.auth.dataAccess.UserProfileRepository;
import com.ozalp.auth.models.entities.UserProfile;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileImpl implements UserProfileService {

    private final UserProfileRepository repository;
    private final UserProfileMapper mapper;

    @Override
    public UserProfile findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User profile not found"));
    }

    @Override
    public UserProfile save(UserProfile userProfile) {
        return repository.save(userProfile);
    }

    @Override
    public void delete(int id) {
        UserProfile userProfile = findById(id);
        userProfile.markAsDelete();
        repository.save(userProfile);
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
