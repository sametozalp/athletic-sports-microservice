package com.ozalp.training.business.impls;

import com.ozalp.training.business.dtos.requests.CreateTrainingProgramRequest;
import com.ozalp.training.business.dtos.responses.TrainingProgramResponse;
import com.ozalp.training.business.mappers.TrainingProgramMapper;
import com.ozalp.training.business.services.TrainingProgramService;
import com.ozalp.training.dataAccess.TrainingProgramRepository;
import com.ozalp.training.models.entities.TrainingProgram;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingProgramImpl implements TrainingProgramService {

    private final TrainingProgramRepository repository;
    private final TrainingProgramMapper mapper;
//    private final UserProfileService userProfileService;

    @Override
    public TrainingProgram findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Training program not found"));
    }

    @Override
    public TrainingProgram save(TrainingProgram trainingProgram) {
        return repository.save(trainingProgram);
    }

    @Override
    public void delete(int id) {
        TrainingProgram trainingProgram = findById(id);
        trainingProgram.markAsDelete();
        repository.save(trainingProgram);
    }

    @Override
    public TrainingProgramResponse create(CreateTrainingProgramRequest request) {
//        UserProfile athlete = userProfileService.findById(request.getAthleteUserProfileId());
//        UserProfile coach = userProfileService.findById(request.getCoachUserProfileId());

        TrainingProgram trainingProgram = mapper.toEntity(request);
//        trainingProgram.setAthlete(athlete);
//        trainingProgram.setCoach(coach);
        return mapper.toResponse(repository.save(trainingProgram));
    }
}
