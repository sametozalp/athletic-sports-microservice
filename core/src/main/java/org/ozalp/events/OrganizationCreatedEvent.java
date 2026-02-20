package org.ozalp.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationCreatedEvent {

    private String ownerEmail;

    private String organizationName;

}
