package com.ozalp.training.business.impls;

import com.ozalp.training.business.dtos.requests.CreateCoachingAssignmentRequest;
import com.ozalp.training.business.services.CoachingAssignmentService;
import com.ozalp.training.dataAccess.CoachingAssignmentRepository;
import com.ozalp.training.models.entities.CoachingAssignment;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoachingAssignmentImpl implements CoachingAssignmentService {

    private final CoachingAssignmentRepository repository;
//    private final UserProfileService userProfileService;

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
    public void create(CreateCoachingAssignmentRequest request) {
//        UserProfile athlete = userProfileService.findById(request.getAthleteUserProfileId());
//        UserProfile coach = userProfileService.findById(request.getCoachUserProfileId());
//        CoachingAssignment coachingAssignment = new CoachingAssignment(athlete, coach);
//        repository.save(coachingAssignment);
    }
}
