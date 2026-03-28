package com.ozalp.motivation_sentence.business.impls;

import com.ozalp.motivation_sentence.business.dtos.CreateMotivationSentenceRequest;
import com.ozalp.motivation_sentence.business.dtos.MotivationSentenceResponse;
import com.ozalp.motivation_sentence.business.services.MotivationSentenceService;
import com.ozalp.motivation_sentence.dataAccess.MotivationSentenceRepository;
import com.ozalp.motivation_sentence.models.entities.MotivationSentence;
import lombok.RequiredArgsConstructor;
import org.ozalp.managers.BaseImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotivationSentenceImpl extends BaseImpl<MotivationSentence> implements MotivationSentenceService {

    private final MotivationSentenceRepository repository;

    @Override
    protected JpaRepository<MotivationSentence, Integer> getRepository() {
        return repository;
    }

    @Override
    public MotivationSentenceResponse create(CreateMotivationSentenceRequest request) {
        MotivationSentence motivationSentence = new MotivationSentence(request.getSentence());
        MotivationSentence saved = repository.save(motivationSentence);
        return MotivationSentenceResponse.builder()
                .sentence(saved.getSentence())
                .build();
    }

    @Override
    public MotivationSentenceResponse getRandomSentence() {
        List<MotivationSentence> list = repository.getRandomSentence(PageRequest.of(0, 1));

        if (!list.isEmpty()) {
            MotivationSentence motivationSentence = list.get(0);
            return MotivationSentenceResponse.builder()
                    .sentence(motivationSentence.getSentence())
                    .build();
        }
        return null;
    }
}
