package com.ozalp.membership.controllers;

import com.ozalp.membership.business.dtos.requests.CreateMembershipRequestRequest;
import com.ozalp.membership.business.services.MembershipRequestService;
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
@RequiredArgsConstructor
@RequestMapping(ApiConst.ApiPath.MEMBERSHIP_REQUEST)
public class MembershipRequestController {

    private final MembershipRequestService membershipRequestService;

    @PostMapping(ApiParams.MembershipRequest.CREATE)
    ResponseEntity<?> create(@RequestBody @Valid CreateMembershipRequestRequest request) {
        return ResponseEntity.ok(membershipRequestService.create(request));
    }
}
