package com.ozalp.mail.consumer;

import com.ozalp.mail.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.ozalp.events.MembershipRequestCreatedEvent;
import org.ozalp.utils.consts.EventConst;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembershipRequestConsumer {

    private final EmailService emailService;

    @KafkaListener(groupId = EventConst.GROUP_ID, topics = EventConst.Topics.CREATED_MEMBERSHIP)
    public void createdMembershipRequest(MembershipRequestCreatedEvent membershipRequestCreatedEvent) {
        String sub = "Request Sent";
        String message = "Organization name: " + membershipRequestCreatedEvent.getOrganizationName();
        emailService.sendMail(membershipRequestCreatedEvent.getAthleteEmail(), sub, message);
    }
}
