package org.ozalp.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MembershipCreatedEvent {

    private String athleteEmail;

    private String organizationName;
}
