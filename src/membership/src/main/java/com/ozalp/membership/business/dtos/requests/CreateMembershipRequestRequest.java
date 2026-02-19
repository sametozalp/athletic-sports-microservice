package com.ozalp.membership.business.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMembershipRequestRequest {

    private int userProfileId;

    private int organizationId;
}
