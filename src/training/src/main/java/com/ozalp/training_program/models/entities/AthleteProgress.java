package com.ozalp.training_program.models.entities;

import com.ozalp.training_program.models.enums.AthleteProgressStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "athlete_progresses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AthleteProgress extends BaseEntity {

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_item_id", nullable = false)
    private TrainingItemTask trainingItemTask;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AthleteProgressStatus status = AthleteProgressStatus.NOT_COMPLETED;

    @Column
    private LocalDateTime completedAt;

    @Column(nullable = false)
    private int pointsEarned;

    @Column
    private int organizationId;

}