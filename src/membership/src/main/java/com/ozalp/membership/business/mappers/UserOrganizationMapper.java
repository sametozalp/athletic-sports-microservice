package com.ozalp.membership.business.mappers;

import com.ozalp.membership.business.dtos.requests.CreateMembershipRequestRequest;
import com.ozalp.membership.business.dtos.responses.MembershipRequestResponse;
import com.ozalp.membership.business.dtos.responses.Organization;
import com.ozalp.membership.business.dtos.responses.UserProfile;
import com.ozalp.membership.models.entities.MembershipRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserOrganizationMapper {

    MembershipRequest toEntity(CreateMembershipRequestRequest request);

    @Mapping(target = "id", source = "membershipRequest.id")
    @Mapping(target = "organization", source = "organization")
    @Mapping(target = "userProfile", source = "userProfile")
    MembershipRequestResponse toResponse(MembershipRequest membershipRequest, Organization organization, UserProfile userProfile);
}
