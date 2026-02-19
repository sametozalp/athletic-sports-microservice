package com.ozalp.auth.controllers;

import com.ozalp.auth.business.dtos.requests.UpdateProfileRequest;
import com.ozalp.auth.business.services.UserProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/userProfile")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping("/update")
    ResponseEntity<?> update(@RequestBody @Valid UpdateProfileRequest request) {
        return ResponseEntity.ok(userProfileService.updateProfile(request));
    }
}
