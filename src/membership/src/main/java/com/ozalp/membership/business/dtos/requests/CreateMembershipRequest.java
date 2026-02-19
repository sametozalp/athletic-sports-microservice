package com.ozalp.membership.business.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateMembershipRequest {

    private int organizationId;

    private int userProfileId;

    private LocalDateTime joined_at;
}
