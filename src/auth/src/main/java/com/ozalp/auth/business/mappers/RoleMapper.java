package com.ozalp.auth.business.mappers;

import com.ozalp.auth.business.dtos.requests.CreateRoleRequest;
import com.ozalp.auth.business.dtos.responses.RoleResponse;
import com.ozalp.auth.models.entities.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleResponse toResponse(Role role);

    Role toEntity(CreateRoleRequest request);
}
