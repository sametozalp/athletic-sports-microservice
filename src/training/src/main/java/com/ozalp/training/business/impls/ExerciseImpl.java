package com.ozalp.training.business.impls;

import com.ozalp.training.business.dtos.requests.CreateExerciseRequest;
import com.ozalp.training.business.dtos.responses.ExerciseResponse;
import com.ozalp.training.business.mappers.ExerciseMapper;
import com.ozalp.training.business.services.ExerciseService;
import com.ozalp.training.dataAccess.ExerciseRepository;
import com.ozalp.training.models.entities.Exercise;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseImpl implements ExerciseService {

    private final ExerciseRepository repository;
    private final ExerciseMapper mapper;

    @Override
    public Exercise findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Exercise not found"));
    }

    @Override
    public Exercise save(Exercise exercise) {
        return null;
    }

    @Override
    public void delete(int id) {
        Exercise exercise = findById(id);
        exercise.markAsDelete();
        repository.save(exercise);
    }

    @Override
    public ExerciseResponse create(CreateExerciseRequest request) {
        Exercise exercise = mapper.toEntity(request);
        return mapper.toResponse(repository.save(exercise));
    }
}
