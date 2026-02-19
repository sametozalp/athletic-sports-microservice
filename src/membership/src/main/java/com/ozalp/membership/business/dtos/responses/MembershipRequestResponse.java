package com.ozalp.membership.business.dtos.responses;

import com.ozalp.membership.models.enums.RequestStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MembershipRequestResponse {

    private int id;

    private UserProfile userProfile;

    private Organization organization;

    private RequestStatus status;
}
