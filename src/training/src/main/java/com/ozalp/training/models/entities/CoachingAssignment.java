package com.ozalp.training.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// which one athlete -> which one coach

@Entity
@Table(name = "coaching_assignments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CoachingAssignment extends BaseEntity {

    @Column(nullable = false)
    private int athleteUserProfileId;

    @Column(nullable = false)
    private int coachUserProfileId;

}
