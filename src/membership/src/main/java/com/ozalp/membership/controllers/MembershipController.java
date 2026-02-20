package com.ozalp.membership.controllers;

import com.ozalp.membership.business.dtos.requests.CreateMembershipRequest;
import com.ozalp.membership.business.services.MembershipService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ozalp.utils.consts.ApiConst;
import org.ozalp.utils.consts.ApiParams;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConst.ApiPath.MEMBERSHIP)
@RequiredArgsConstructor
public class MembershipController {

    private final MembershipService membershipService;

    @PostMapping(ApiParams.Membership.CREATE)
    ResponseEntity<?> create(@RequestBody @Valid CreateMembershipRequest request) {
        return ResponseEntity.ok(membershipService.create(request));
    }
}
