package com.ozalp.motivation_sentence.business.services;

import com.ozalp.motivation_sentence.business.dtos.CreateMotivationSentenceRequest;
import com.ozalp.motivation_sentence.business.dtos.MotivationSentenceResponse;
import com.ozalp.motivation_sentence.models.entities.MotivationSentence;

public interface MotivationSentenceService extends BaseService<MotivationSentence> {

    MotivationSentenceResponse create(CreateMotivationSentenceRequest request);

    MotivationSentenceResponse getRandomSentence();

}
