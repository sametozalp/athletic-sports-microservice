package com.ozalp.training.business.impls;

import com.ozalp.training.business.dtos.requests.CreateCoachingAssignmentRequest;
import com.ozalp.training.business.dtos.responses.UserProfile;
import com.ozalp.training.business.services.CoachingAssignmentService;
import com.ozalp.training.clients.UserProfileClient;
import com.ozalp.training.dataAccess.CoachingAssignmentRepository;
import com.ozalp.training.models.entities.CoachingAssignment;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CoachingAssignmentImpl implements CoachingAssignmentService {

    private final CoachingAssignmentRepository repository;
    //    private final UserProfileService userProfileService;
    private final UserProfileClient userProfileClient;

    @Override
    public CoachingAssignment findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Coaching assigment not found"));
    }

    @Override
    public CoachingAssignment save(CoachingAssignment coachingAssignment) {
        return repository.save(coachingAssignment);
    }

    @Override
    public void delete(int id) {
        CoachingAssignment coachingAssignment = findById(id);
        coachingAssignment.markAsDelete();
        repository.save(coachingAssignment);
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
