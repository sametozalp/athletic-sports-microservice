package com.ozalp.training.business.impls;

import com.ozalp.training.business.dtos.requests.CreateTrainingProgramRequest;
import com.ozalp.training.business.dtos.responses.TrainingProgramResponse;
import com.ozalp.training.business.dtos.responses.UserProfile;
import com.ozalp.training.business.mappers.TrainingProgramMapper;
import com.ozalp.training.business.services.TrainingProgramService;
import com.ozalp.training.clients.UserProfileClient;
import com.ozalp.training.dataAccess.TrainingProgramRepository;
import com.ozalp.training.models.entities.TrainingProgram;
import lombok.RequiredArgsConstructor;
import org.ozalp.events.TrainingProgramCreatedEvent;
import org.ozalp.managers.BaseImpl;
import org.ozalp.utils.consts.EventConst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TrainingProgramImpl extends BaseImpl<TrainingProgram> implements TrainingProgramService {

    private final TrainingProgramRepository repository;
    private final TrainingProgramMapper mapper;
    private final UserProfileClient userProfileClient;
    private final KafkaTemplate<String, TrainingProgramCreatedEvent> kafkaTemplate;

    @Override
    protected JpaRepository<TrainingProgram, Integer> getRepository() {
        return repository;
    }

    @Override
    @Transactional
    public TrainingProgramResponse create(CreateTrainingProgramRequest request) {
        UserProfile athlete = userProfileClient.getProfileDetail(request.getAthleteUserProfileId());
        UserProfile coach = userProfileClient.getProfileDetail(request.getCoachUserProfileId());

        TrainingProgram trainingProgram = mapper.toEntity(request);
        trainingProgram.setAthleteUserProfileId(athlete.getId());
        trainingProgram.setCoachUserProfileId(coach.getId());
        kafkaTemplate.send(EventConst.Topics.CREATED_TRAINING_PROGRAM, new TrainingProgramCreatedEvent(athlete.getEmail(), trainingProgram.getId()));
        return mapper.toResponse(repository.save(trainingProgram), athlete, coach);
    }
}
