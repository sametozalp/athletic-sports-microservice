package com.ozalp.mail.consumer;

import com.ozalp.mail.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.ozalp.events.OrganizationCreatedEvent;
import org.ozalp.utils.consts.EventConst;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationConsumer {

    private final EmailService emailService;

    @KafkaListener(groupId = EventConst.GROUP_ID, topics = EventConst.Topics.CREATED_ORGANIZATION)
    public void createdOrganization(OrganizationCreatedEvent organizationCreatedEvent) {
        String sub = "Created Organization: " + organizationCreatedEvent.getOrganizationName();
        String message = "Created Organization: " + organizationCreatedEvent.getOrganizationName();
        emailService.sendMail(organizationCreatedEvent.getOwnerEmail(), sub, message);
    }
}
