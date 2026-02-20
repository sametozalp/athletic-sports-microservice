package org.ozalp.events;

public class TrainingProgramCreatedEvent {

    private String userEmail;

    private int trainingProgramId;

    public TrainingProgramCreatedEvent() {
    }

    public TrainingProgramCreatedEvent(String userEmail, int trainingProgramId) {
        this.userEmail = userEmail;
        this.trainingProgramId = trainingProgramId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public int getTrainingProgramId() {
        return trainingProgramId;
    }
}
