package com.ozalp.mail.consumer;

import com.ozalp.mail.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.ozalp.events.TrainingProgramCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingProgramConsumer {

    private final EmailService emailService;

    @KafkaListener(groupId = "mail", topics = "created-training-program")
    public void createdTrainingProgram(TrainingProgramCreatedEvent trainingProgramCreatedEvent) {
        String sub = "Created Program";
        String message = "Program Id: " + trainingProgramCreatedEvent.getTrainingProgramId();
        emailService.sendMail(trainingProgramCreatedEvent.getUserEmail(), sub, message);
    }
}
