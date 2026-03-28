package com.ozalp.mail.consumer;

import com.ozalp.mail.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.ozalp.events.QuickStartEvent;
import org.ozalp.utils.consts.EventConst;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuickStartConsumer {

    private final EmailService emailService;

    @KafkaListener(groupId = EventConst.QUICK_START_GROUP_ID, topics = EventConst.QuickStartSaga.QUICK_START_TRAINING_STAGE_COMPLETED)
    public void sendMail(QuickStartEvent quickStartEvent) {
        String subject = "Quick Start Mail";
        String message = "Dear " + quickStartEvent.getAuthUsername() + ". Your quick start created. Enjoy it.";
        emailService.sendMail(quickStartEvent.getAuthEmail(), subject, message);
    }
}
