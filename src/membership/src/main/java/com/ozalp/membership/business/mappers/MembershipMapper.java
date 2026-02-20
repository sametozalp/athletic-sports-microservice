package com.ozalp.membership.business.mappers;

import com.ozalp.membership.business.dtos.requests.CreateMembershipRequest;
import com.ozalp.membership.business.dtos.responses.MembershipResponse;
import com.ozalp.membership.business.dtos.responses.Organization;
import com.ozalp.membership.business.dtos.responses.UserProfile;
import com.ozalp.membership.models.entities.Membership;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MembershipMapper {

    Membership toEntity(CreateMembershipRequest request);

    @Mapping(target = "id", source = "membership.id")
    @Mapping(target = "organization", source = "organization")
    @Mapping(target = "userProfile", source = "userProfile")
    MembershipResponse toResponse(Membership membership, Organization organization, UserProfile userProfile);
}
