package com.ozalp.training.business.services;

import com.ozalp.training.business.dtos.requests.CreateCoachingAssignmentRequest;
import com.ozalp.training.models.entities.CoachingAssignment;
import org.ozalp.services.BaseService;

public interface CoachingAssignmentService extends BaseService<CoachingAssignment> {

    void create(CreateCoachingAssignmentRequest request);
}
