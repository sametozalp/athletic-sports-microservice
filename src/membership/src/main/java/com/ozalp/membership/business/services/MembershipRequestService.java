package com.ozalp.membership.business.services;

import com.ozalp.membership.business.dtos.requests.CreateMembershipRequestRequest;
import com.ozalp.membership.business.dtos.responses.MembershipRequestResponse;
import com.ozalp.membership.models.entities.MembershipRequest;

public interface MembershipRequestService extends BaseService<MembershipRequest> {

    MembershipRequestResponse create(CreateMembershipRequestRequest request);

}
