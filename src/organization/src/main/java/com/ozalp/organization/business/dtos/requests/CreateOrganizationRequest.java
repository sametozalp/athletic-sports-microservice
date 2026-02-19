package com.ozalp.organization.business.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrganizationRequest {

    private int ownerUserProfileId;

    private String name;

    private String logoUrl;

}
