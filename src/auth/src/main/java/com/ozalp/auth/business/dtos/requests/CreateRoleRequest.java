package com.ozalp.auth.business.dtos.requests;

import com.ozalp.auth.models.enums.RoleEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRoleRequest {
    private RoleEnum name;
}
