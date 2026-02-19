package com.ozalp.healthy_eating_tip.business.impls;

import com.ozalp.healthy_eating_tip.business.dtos.requests.CreateHealthyEatingTipRequest;
import com.ozalp.healthy_eating_tip.business.dtos.responses.HealthyEatingTipResponse;
import com.ozalp.healthy_eating_tip.business.services.HealthyEatingTipService;
import com.ozalp.healthy_eating_tip.dataAccess.HealthyEatingTipRepository;
import com.ozalp.healthy_eating_tip.models.entities.HealthyEatingTip;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HealthyEatingTipImpl implements HealthyEatingTipService {

    private final HealthyEatingTipRepository repository;

    @Override
    public HealthyEatingTip findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Healthy eating tip not found"));
    }

    @Override
    public HealthyEatingTip save(HealthyEatingTip healthyEatingTip) {
        return repository.save(healthyEatingTip);
    }

    @Override
    public void delete(int id) {
        HealthyEatingTip healthyEatingTip = findById(id);
        healthyEatingTip.markAsDelete();
        repository.save(healthyEatingTip);
    }

    @Override
    public HealthyEatingTipResponse create(CreateHealthyEatingTipRequest request) {
        HealthyEatingTip healthyEatingTip = new HealthyEatingTip(request.getTitle(), request.getDescription());
        HealthyEatingTip saved = repository.save(healthyEatingTip);
        return HealthyEatingTipResponse.builder()
                .title(saved.getTitle())
                .description(saved.getDescription())
                .build();
    }

    @Override
    public HealthyEatingTipResponse getRandomTip() {
        List<HealthyEatingTip> list = repository.getRandomTip(PageRequest.of(0, 1));

        if (!list.isEmpty()) {
            HealthyEatingTip healthyEatingTip = list.get(0);
            return HealthyEatingTipResponse.builder()
                    .title(healthyEatingTip.getTitle())
                    .description(healthyEatingTip.getDescription())
                    .icon(healthyEatingTip.getIcon())
                    .build();
        }
        return null;
    }
}
