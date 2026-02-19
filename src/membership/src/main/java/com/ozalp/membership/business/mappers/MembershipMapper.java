package com.ozalp.membership.business.mappers;

import com.ozalp.membership.business.dtos.requests.CreateMembershipRequest;
import com.ozalp.membership.business.dtos.responses.MembershipResponse;
import com.ozalp.membership.models.entities.Membership;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MembershipMapper {

    Membership toEntity(CreateMembershipRequest request);

    MembershipResponse toResponse(Membership membership);
}
