package com.ozalp.auth.business.dtos.responses;

import com.ozalp.auth.models.enums.RoleEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleResponse {
    private int id;
    private RoleEnum name;
}
