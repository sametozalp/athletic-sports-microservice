package com.ozalp.organization.business.services;

import com.ozalp.organization.business.dtos.requests.CreateOrganizationRequest;
import com.ozalp.organization.business.dtos.responses.OrganizationResponse;
import com.ozalp.organization.models.entities.Organization;

public interface OrganizationService extends BaseService<Organization> {

    OrganizationResponse create(CreateOrganizationRequest request);

    OrganizationResponse getOrganizationDetail(int id);
}
