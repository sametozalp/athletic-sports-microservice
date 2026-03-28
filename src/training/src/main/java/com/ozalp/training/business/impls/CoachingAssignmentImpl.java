package com.ozalp.training.business.impls;

import com.ozalp.training.business.dtos.requests.CreateCoachingAssignmentRequest;
import com.ozalp.training.business.dtos.responses.UserProfile;
import com.ozalp.training.business.services.CoachingAssignmentService;
import com.ozalp.training.clients.UserProfileClient;
import com.ozalp.training.dataAccess.CoachingAssignmentRepository;
import com.ozalp.training.models.entities.CoachingAssignment;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.ozalp.managers.BaseImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CoachingAssignmentImpl extends BaseImpl<CoachingAssignment> implements CoachingAssignmentService {

    private final CoachingAssignmentRepository repository;
    private final UserProfileClient userProfileClient;

    @Override
    protected JpaRepository<CoachingAssignment, Integer> getRepository() {
        return repository;
    }

    @Override
    @Transactional
    public void create(CreateCoachingAssignmentRequest request) {
        UserProfile athlete = userProfileClient.getProfileDetail(request.getAthleteUserProfileId());
        UserProfile coach = userProfileClient.getProfileDetail(request.getCoachUserProfileId());
        CoachingAssignment coachingAssignment = new CoachingAssignment(athlete.getId(), coach.getId());
        repository.save(coachingAssignment);
    }
}
