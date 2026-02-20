package com.ozalp.mail.consumer;

import com.ozalp.mail.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.ozalp.events.UserCreatedEvent;
import org.ozalp.utils.consts.EventConst;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthConsumer {

    private final EmailService emailService;

    @KafkaListener(groupId = EventConst.GROUP_ID, topics = EventConst.Topics.CREATED_USER_PROFILE)
    public void createdAuth(UserCreatedEvent userCreatedEvent) {

        String subject = "Created Account";

        String message = "Created account:\n" +
                "Mail: " + userCreatedEvent.getEmail() + "\n" +
                "Username: " + userCreatedEvent.getUsername();

        emailService.sendMail(userCreatedEvent.getEmail(), subject, message);

    }
}
