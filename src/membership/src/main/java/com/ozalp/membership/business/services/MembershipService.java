package com.ozalp.membership.business.services;

import com.ozalp.membership.business.dtos.requests.CreateMembershipRequest;
import com.ozalp.membership.business.dtos.responses.MembershipResponse;
import com.ozalp.membership.models.entities.Membership;
import org.ozalp.services.BaseService;

public interface MembershipService extends BaseService<Membership> {

    MembershipResponse create(CreateMembershipRequest request);

}
