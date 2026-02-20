package com.ozalp.mail.consumer;

import com.ozalp.mail.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.ozalp.events.TrainingProgramCreatedEvent;
import org.ozalp.utils.consts.EventConst;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingProgramConsumer {

    private final EmailService emailService;

    @KafkaListener(groupId = EventConst.GROUP_ID, topics = EventConst.Topics.CREATED_TRAINING_PROGRAM)
    public void createdTrainingProgram(TrainingProgramCreatedEvent trainingProgramCreatedEvent) {
        String sub = "Created Program";
        String message = "Program Id: " + trainingProgramCreatedEvent.getTrainingProgramId();
        emailService.sendMail(trainingProgramCreatedEvent.getUserEmail(), sub, message);
    }
}
