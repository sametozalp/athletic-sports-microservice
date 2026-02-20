package com.ozalp.auth.controllers;

import com.ozalp.auth.business.dtos.requests.UpdateProfileRequest;
import com.ozalp.auth.business.services.UserProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ozalp.utils.consts.ApiConst;
import org.ozalp.utils.consts.ApiParams;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiConst.ApiPath.USER_PROFILE)
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping(ApiParams.UserProfile.UPDATE)
    ResponseEntity<?> update(@RequestBody @Valid UpdateProfileRequest request) {
        return ResponseEntity.ok(userProfileService.updateProfile(request));
    }

    @GetMapping(ApiParams.UserProfile.GET_PROFILE_DETAIL)
    ResponseEntity<?> findById(@PathVariable int id) {
        return ResponseEntity.ok(userProfileService.getProfileDetail(id));
    }
}
