package com.ozalp.training.business.impls;

import com.ozalp.training.business.dtos.requests.CreateExerciseRequest;
import com.ozalp.training.business.dtos.responses.ExerciseResponse;
import com.ozalp.training.business.mappers.ExerciseMapper;
import com.ozalp.training.business.services.ExerciseService;
import com.ozalp.training.dataAccess.ExerciseRepository;
import com.ozalp.training.models.entities.Exercise;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.ozalp.managers.BaseImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseImpl extends BaseImpl<Exercise> implements ExerciseService {

    private final ExerciseRepository repository;
    private final ExerciseMapper mapper;

    @Override
    protected JpaRepository<Exercise, Integer> getRepository() {
        return repository;
    }

    @Override
    public ExerciseResponse create(CreateExerciseRequest request) {
        Exercise exercise = mapper.toEntity(request);
        return mapper.toResponse(repository.save(exercise));
    }
}
