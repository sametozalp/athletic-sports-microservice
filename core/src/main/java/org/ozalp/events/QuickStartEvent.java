package org.ozalp.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuickStartEvent {

    private int authId;
    private String authEmail;
    private String authUsername;

    private int organizationId;

    private int membershipId;

    private int trainingProgramId;

    public QuickStartEvent(int authId, String authEmail, String authUsername, int organizationId) {
        this.authId = authId;
        this.authEmail = authEmail;
        this.authUsername = authUsername;
        this.organizationId = organizationId;
    }

    public QuickStartEvent(int authId, String authEmail, String authUsername, int organizationId, int membershipId) {
        this.authId = authId;
        this.authEmail = authEmail;
        this.authUsername = authUsername;
        this.organizationId = organizationId;
        this.membershipId = membershipId;
    }
}
