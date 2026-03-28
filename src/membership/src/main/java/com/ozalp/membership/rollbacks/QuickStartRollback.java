package com.ozalp.membership.rollbacks;

import com.ozalp.membership.business.services.MembershipService;
import lombok.RequiredArgsConstructor;
import org.ozalp.events.QuickStartEvent;
import org.ozalp.utils.consts.EventConst;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuickStartRollback {

    private final MembershipService membershipService;

    @KafkaListener(groupId = EventConst.QUICK_START_GROUP_ID, topics = EventConst.QuickStartSagaRollback.QUICK_START_MEMBERSHIP_STAGE_ROLLBACK)
    public void deleteMembership(QuickStartEvent quickStartEvent) {
        membershipService.delete(quickStartEvent.getMembershipId());
    }
}
