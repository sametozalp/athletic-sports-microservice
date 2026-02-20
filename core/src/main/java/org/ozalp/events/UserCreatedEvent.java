package org.ozalp.events;

public class UserCreatedEvent {

    private String email;

    private String username;

    public UserCreatedEvent() {
    }

    public UserCreatedEvent(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
}
