package com.ozalp.training.business.impls;

import com.ozalp.training.business.dtos.requests.CreateAthleteProgressRequest;
import com.ozalp.training.business.dtos.responses.AthleteProgressResponse;
import com.ozalp.training.business.dtos.responses.Organization;
import com.ozalp.training.business.mappers.AthleteProgressMapper;
import com.ozalp.training.business.services.AthleteProgressService;
import com.ozalp.training.business.services.TrainingItemTaskService;
import com.ozalp.training.clients.OrganizationClient;
import com.ozalp.training.dataAccess.AthleteProgressRepository;
import com.ozalp.training.models.entities.AthleteProgress;
import com.ozalp.training.models.entities.TrainingItemTask;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AthleteProgressImpl implements AthleteProgressService {

    private final AthleteProgressRepository repository;
    private final AthleteProgressMapper mapper;
    private final TrainingItemTaskService trainingItemTaskService;
    private final OrganizationClient organizationClient;

    @Override
    public AthleteProgress findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Athlete progress not found"));
    }

    @Override
    public AthleteProgress save(AthleteProgress athleteProgress) {
        return repository.save(athleteProgress);
    }

    @Override
    public void delete(int id) {
        AthleteProgress athleteProgress = findById(id);
        athleteProgress.markAsDelete();
        repository.save(athleteProgress);
    }

    @Override
    public AthleteProgressResponse create(CreateAthleteProgressRequest request) {
        Organization organization = organizationClient.getOrganizationDetail(request.getOrganizationId());
        TrainingItemTask trainingItemTask = trainingItemTaskService.findById(request.getTrainingItemId());
        AthleteProgress athleteProgress = mapper.toEntity(request);
        athleteProgress.setOrganizationId(organization.getId());
        athleteProgress.setTrainingItemTask(trainingItemTask);
        athleteProgress.setPointsEarned(trainingItemTask.getPoint());
        return mapper.toResponse(repository.save(athleteProgress));
    }

    @Override
    public int getTotalPointThisMonth(int userProfileId) {
        return repository.getTotalPointThisMonth(userProfileId);
    }

    @Override
    public int getAchievementPercentageThisMonth(int userProfile) {
        return repository.getAchievementPercentageThisMonth(userProfile);
    }

    @Override
    public List<AthleteProgressResponse> getDailyMissions(int userProfileId) {
        LocalDate fromDate = LocalDate.now().minusDays(1);
        return repository.getDailyMissions(userProfileId, fromDate)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}
