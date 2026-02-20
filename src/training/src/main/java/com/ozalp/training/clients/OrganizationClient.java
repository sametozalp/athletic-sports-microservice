package com.ozalp.training.clients;

import com.ozalp.training.business.dtos.responses.Organization;
import org.ozalp.utils.consts.ApiConst;
import org.ozalp.utils.consts.ApiParams;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "organization", url = "${organizationClientUrl}")
public interface OrganizationClient {

    @GetMapping(ApiConst.ApiPath.ORGANIZATION + ApiParams.Organization.GET_ORGANIZATION_DETAIL)
    Organization getOrganizationDetail(@PathVariable int id);

}
