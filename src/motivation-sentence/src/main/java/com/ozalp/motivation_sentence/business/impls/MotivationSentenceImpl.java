package com.ozalp.motivation_sentence.business.impls;

import com.ozalp.motivation_sentence.business.dtos.CreateMotivationSentenceRequest;
import com.ozalp.motivation_sentence.business.dtos.MotivationSentenceResponse;
import com.ozalp.motivation_sentence.business.services.MotivationSentenceService;
import com.ozalp.motivation_sentence.dataAccess.MotivationSentenceRepository;
import com.ozalp.motivation_sentence.models.entities.MotivationSentence;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotivationSentenceImpl implements MotivationSentenceService {

    private final MotivationSentenceRepository repository;

    @Override
    public MotivationSentence findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Motivation sentence not found"));
    }

    @Override
    public MotivationSentence save(MotivationSentence motivationSentence) {
        return repository.save(motivationSentence);
    }

    @Override
    public void delete(int id) {
        MotivationSentence motivationSentence = findById(id);
        motivationSentence.markAsDelete();
        repository.save(motivationSentence);
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

        if(!list.isEmpty()) {
            MotivationSentence motivationSentence = list.get(0);
            return MotivationSentenceResponse.builder()
                    .sentence(motivationSentence.getSentence())
                    .build();        }
        return null;
    }
}
