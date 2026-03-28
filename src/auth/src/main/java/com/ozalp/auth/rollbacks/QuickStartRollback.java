package com.ozalp.auth.rollbacks;

import com.ozalp.auth.business.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.ozalp.events.QuickStartEvent;
import org.ozalp.utils.consts.EventConst;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuickStartRollback {

    private final AuthService authService;

    @KafkaListener(groupId = EventConst.QUICK_START_GROUP_ID, topics = EventConst.QuickStartSagaRollback.QUICK_START_AUTH_STAGE_ROLLBACK)
    public void deleteAuth(QuickStartEvent quickStartEvent) {
        authService.delete(quickStartEvent.getAuthId());
    }
}
