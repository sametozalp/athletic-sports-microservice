package com.ozalp.membership.business.mappers;

import com.ozalp.membership.business.dtos.requests.CreateMembershipRequestRequest;
import com.ozalp.membership.business.dtos.responses.MembershipRequestResponse;
import com.ozalp.membership.models.entities.MembershipRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserOrganizationMapper {

    MembershipRequest toEntity(CreateMembershipRequestRequest request);
    MembershipRequestResponse toResponse(MembershipRequest membershipRequest);
}
