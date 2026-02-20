package org.ozalp.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingProgramCreatedEvent {

    private String userEmail;

    private int trainingProgramId;

}
