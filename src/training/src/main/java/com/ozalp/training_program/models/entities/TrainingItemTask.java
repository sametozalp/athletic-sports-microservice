package com.ozalp.training_program.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "training_item_tasks")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class TrainingItemTask extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_program_id", nullable = false)
    private TrainingProgram trainingProgram;

    @Column(nullable = false)
    private int point; // automatic calculate (like reps * 3 )

    @Column(nullable = false)
    private LocalDate date;

    @Column
    private String coachNote;
}
