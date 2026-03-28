package com.ozalp.training.consumers;

import com.ozalp.training.business.dtos.requests.CreateTrainingProgramRequest;
import com.ozalp.training.business.dtos.responses.TrainingProgramResponse;
import com.ozalp.training.business.services.TrainingProgramService;
import lombok.RequiredArgsConstructor;
import org.ozalp.events.QuickStartEvent;
import org.ozalp.utils.consts.EventConst;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class QuickStartConsumer {

    private final TrainingProgramService trainingProgramService;
    private final KafkaTemplate<String, QuickStartEvent> kafkaTemplate;

    @KafkaListener(groupId = EventConst.QUICK_START_GROUP_ID, topics = EventConst.QuickStartSaga.QUICK_START_MEMBERSHIP_STAGE_COMPLETED)
    public void createTraining(QuickStartEvent quickStartEvent) {
        try {
            TrainingProgramResponse trainingProgram = trainingProgramService.create(new CreateTrainingProgramRequest(1, 1, "test title", "test description", LocalDateTime.now(), LocalDateTime.now().plusWeeks(1)));
            quickStartEvent.setTrainingProgramId(trainingProgram.getId());
            kafkaTemplate.send(EventConst.QuickStartSaga.QUICK_START_TRAINING_STAGE_COMPLETED, quickStartEvent);
        } catch (Exception e) {
            kafkaTemplate.send(EventConst.QuickStartSagaRollback.QUICK_START_MEMBERSHIP_STAGE_ROLLBACK, quickStartEvent);
            kafkaTemplate.send(EventConst.QuickStartSagaRollback.QUICK_START_AUTH_STAGE_ROLLBACK, quickStartEvent);
        }
    }
}
