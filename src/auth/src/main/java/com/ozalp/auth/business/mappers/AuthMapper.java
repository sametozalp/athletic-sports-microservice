package com.ozalp.auth.business.mappers;

import com.ozalp.auth.business.dtos.requests.RegisterRequest;
import com.ozalp.auth.business.dtos.responses.AuthResponse;
import com.ozalp.auth.models.entities.Auth;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    AuthResponse toResponse(Auth auth);

    Auth toEntity(RegisterRequest request);
}
