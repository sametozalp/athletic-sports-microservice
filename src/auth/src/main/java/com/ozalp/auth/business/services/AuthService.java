package com.ozalp.auth.business.services;

import com.ozalp.auth.business.dtos.requests.RegisterRequest;
import com.ozalp.auth.business.dtos.responses.AuthResponse;
import com.ozalp.auth.models.entities.Auth;
import org.ozalp.services.BaseService;

public interface AuthService extends BaseService<Auth> {

    AuthResponse register(RegisterRequest request);
}
