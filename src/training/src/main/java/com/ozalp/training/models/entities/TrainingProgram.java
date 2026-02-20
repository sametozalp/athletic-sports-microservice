package com.ozalp.training.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ozalp.models.entites.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "training_programs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingProgram extends BaseEntity {

    @Column
    private int coachUserProfileId;

    @Column(nullable = false)
    private int athleteUserProfileId;

    @Column
    private String title;

    @Column
    private String description;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;
}