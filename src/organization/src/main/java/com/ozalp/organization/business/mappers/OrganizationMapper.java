package com.ozalp.organization.business.mappers;

import com.ozalp.organization.business.dtos.requests.CreateOrganizationRequest;
import com.ozalp.organization.business.dtos.responses.OrganizationResponse;
import com.ozalp.organization.models.entities.Organization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    OrganizationResponse toResponse(Organization organization);

    Organization toEntity(CreateOrganizationRequest request);
}
