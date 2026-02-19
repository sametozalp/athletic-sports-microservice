package com.ozalp.organization.dataAccess;

import com.ozalp.organization.models.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
}
