package com.ozalp.training_program.business.mappers;
import com.ozalp.training_program.business.dtos.requests.CreateAthleteProgressRequest;
import com.ozalp.training_program.business.dtos.responses.AthleteProgressResponse;
import com.ozalp.training_program.models.entities.AthleteProgress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AthleteProgressMapper {
    AthleteProgressResponse toResponse(AthleteProgress athleteProgress);
    AthleteProgress toEntity(CreateAthleteProgressRequest request);
}
