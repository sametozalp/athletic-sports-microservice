package com.ozalp.membership.consumers;

import com.ozalp.membership.business.dtos.requests.CreateMembershipRequest;
import com.ozalp.membership.business.dtos.responses.MembershipResponse;
import com.ozalp.membership.business.services.MembershipService;
import lombok.RequiredArgsConstructor;
import org.ozalp.events.QuickStartEvent;
import org.ozalp.utils.consts.EventConst;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuickStartConsumer {

    private final MembershipService membershipService;
    private final KafkaTemplate<String, QuickStartEvent> kafkaTemplate;

    @KafkaListener(groupId = EventConst.QUICK_START_GROUP_ID, topics = EventConst.QuickStartSaga.QUICK_START_AUTH_STAGE_COMPLETED)
    public void createMembership(QuickStartEvent quickStartEvent) {
        try {
            MembershipResponse response = membershipService.create(new CreateMembershipRequest(quickStartEvent.getOrganizationId(), quickStartEvent.getAuthId()));
            quickStartEvent.setMembershipId(response.getId());
            kafkaTemplate.send(EventConst.QuickStartSaga.QUICK_START_MEMBERSHIP_STAGE_COMPLETED, quickStartEvent);
        } catch (Exception e) {
            kafkaTemplate.send(EventConst.QuickStartSagaRollback.QUICK_START_AUTH_STAGE_ROLLBACK, quickStartEvent);
        }
    }
}
