package com.ozalp.training.dataAccess;

import com.ozalp.training.models.entities.CoachingAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachingAssignmentRepository extends JpaRepository<CoachingAssignment, Integer> {
}
