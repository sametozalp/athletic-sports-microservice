package com.ozalp.organization.controllers;

import com.ozalp.organization.business.dtos.requests.CreateOrganizationRequest;
import com.ozalp.organization.business.services.OrganizationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ozalp.utils.consts.ApiConst;
import org.ozalp.utils.consts.ApiParams;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConst.ApiPath.ORGANIZATION)
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping(ApiParams.Organization.CREATE)
    ResponseEntity<?> create(@RequestBody @Valid CreateOrganizationRequest request) {
        return ResponseEntity.ok(organizationService.create(request));
    }

    @GetMapping(ApiParams.Organization.GET_ORGANIZATION_DETAIL)
    ResponseEntity<?> getOrganizationDetail(@PathVariable int id) {
        return ResponseEntity.ok(organizationService.getOrganizationDetail(id));
    }
}
