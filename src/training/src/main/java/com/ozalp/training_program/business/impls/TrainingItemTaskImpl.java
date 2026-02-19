package com.ozalp.training_program.business.impls;

import com.ozalp.training_program.business.dtos.responses.TrainingItemTaskResponse;
import com.ozalp.training_program.business.mappers.TrainingItemMapper;
import com.ozalp.training_program.business.services.TrainingItemTaskService;
import com.ozalp.training_program.dataAccess.TrainingItemTaskRepository;
import com.ozalp.training_program.models.entities.TrainingItemTask;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingItemTaskImpl implements TrainingItemTaskService {

    private final TrainingItemTaskRepository repository;
    private final TrainingItemMapper mapper;

    @Override
    public TrainingItemTask findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Training item not found"));
    }

    @Override
    public TrainingItemTask save(TrainingItemTask trainingItemTask) {
        return repository.save(trainingItemTask);
    }

    @Override
    public void delete(int id) {
        TrainingItemTask trainingItemTask = findById(id);
        trainingItemTask.markAsDelete();
        repository.save(trainingItemTask);
    }

    @Override
    public List<TrainingItemTaskResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}
