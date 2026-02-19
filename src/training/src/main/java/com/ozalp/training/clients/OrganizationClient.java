package com.ozalp.training.clients;

import com.ozalp.training.business.dtos.responses.Organization;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "organization", url = "${organizationClientUrl}")
public interface OrganizationClient {

    @GetMapping("/api/organization/getDetail/{id}")
    Organization getOrganizationDetail(@PathVariable int id);

}
