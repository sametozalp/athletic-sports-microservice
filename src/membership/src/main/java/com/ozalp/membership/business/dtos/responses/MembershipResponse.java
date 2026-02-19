package com.ozalp.membership.business.dtos.responses;

import com.ozalp.membership.models.enums.MembershipStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MembershipResponse {

    private int id;

    private UserProfile userProfile;

    private LocalDateTime joined_at;

    private LocalDateTime left_at;

    private MembershipStatus membershipStatus;
}
