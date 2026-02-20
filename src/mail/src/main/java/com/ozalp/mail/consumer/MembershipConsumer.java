package com.ozalp.mail.consumer;

import com.ozalp.mail.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.ozalp.events.MembershipCreatedEvent;
import org.ozalp.utils.consts.EventConst;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembershipConsumer {

    private final EmailService emailService;

    @KafkaListener(groupId = EventConst.GROUP_ID, topics = EventConst.Topics.CREATED_MEMBERSHIP)
    public void createdMembership(MembershipCreatedEvent membershipCreatedEvent) {
        String sub = "Membership Accepted";
        String message = "Organization name: " + membershipCreatedEvent.getOrganizationName();
        emailService.sendMail(membershipCreatedEvent.getAthleteEmail(), sub, message);
    }
}
