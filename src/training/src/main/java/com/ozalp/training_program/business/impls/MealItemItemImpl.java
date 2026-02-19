package com.ozalp.training_program.business.impls;

import com.ozalp.training_program.business.dtos.requests.CreateMealItemTaskRequest;
import com.ozalp.training_program.business.dtos.responses.MealItemResponse;
import com.ozalp.training_program.business.mappers.MealItemMapper;
import com.ozalp.training_program.business.services.AthleteProgressService;
import com.ozalp.training_program.business.services.MealItemService;
import com.ozalp.training_program.business.services.TrainingProgramService;
import com.ozalp.training_program.dataAccess.MealItemRepository;
import com.ozalp.training_program.models.entities.AthleteProgress;
import com.ozalp.training_program.models.entities.MealItemTask;
import com.ozalp.training_program.models.entities.TrainingProgram;
import com.ozalp.training_program.models.enums.AthleteProgressStatus;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MealItemItemImpl implements MealItemService {

    private final MealItemRepository repository;
    private final MealItemMapper mapper;
    private final TrainingProgramService trainingProgramService;
    private final AthleteProgressService athleteProgressService;

    @Override
    public MealItemTask findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Meal item not found"));
    }

    @Override
    public MealItemTask save(MealItemTask mealItemTask) {
        return repository.save(mealItemTask);
    }

    @Override
    public void delete(int id) {
        MealItemTask mealItemTask = findById(id);
        mealItemTask.markAsDelete();
        repository.save(mealItemTask);
    }

    @Transactional
    @Override
    public MealItemResponse create(CreateMealItemTaskRequest request) {
        TrainingProgram trainingProgram = trainingProgramService.findById(request.getTrainingProgramId());
        MealItemTask mealItemTask = mapper.toEntity(request);
        mealItemTask.setTrainingProgram(trainingProgram);
        mealItemTask.setDate(request.getDate());

        AthleteProgress athleteProgress = new AthleteProgress(
                mealItemTask,
                AthleteProgressStatus.NOT_COMPLETED,
                null,
                mealItemTask.getPoint()
        );

        athleteProgressService.save(athleteProgress);

        return mapper.toResponse(repository.save(mealItemTask));
    }
}
