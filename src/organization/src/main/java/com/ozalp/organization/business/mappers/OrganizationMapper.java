package com.ozalp.organization.business.mappers;

import com.ozalp.organization.business.dtos.requests.CreateOrganizationRequest;
import com.ozalp.organization.business.dtos.responses.OrganizationResponse;
import com.ozalp.organization.business.dtos.responses.UserProfile;
import com.ozalp.organization.models.entities.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    @Mapping(target = "id", source = "organization.id")
    @Mapping(target = "name", source = "organization.name")
    @Mapping(target = "owner", source = "owner")
    OrganizationResponse toResponse(Organization organization, UserProfile owner);

    Organization toEntity(CreateOrganizationRequest request);
}
