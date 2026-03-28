package com.ozalp.training.rollbacks;

import com.ozalp.training.business.services.TrainingProgramService;
import lombok.RequiredArgsConstructor;
import org.ozalp.events.QuickStartEvent;
import org.ozalp.utils.consts.EventConst;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuickStartRollback {

    private final TrainingProgramService trainingProgramService;

    @KafkaListener(groupId = EventConst.QUICK_START_GROUP_ID, topics = EventConst.QuickStartSagaRollback.QUICK_START_TRAINING_STAGE_ROLLBACK)
    public void deleteProgram(QuickStartEvent quickStartEvent) {
        trainingProgramService.delete(quickStartEvent.getAuthId());
    }
}
