package com.ozalp.auth.controllers;

import com.ozalp.auth.business.dtos.requests.RegisterRequest;
import com.ozalp.auth.business.services.AuthService;
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
@RequestMapping(ApiConst.ApiPath.AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(ApiParams.Auth.REGISTER)
    ResponseEntity<?> register(@RequestBody @Valid RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
}
