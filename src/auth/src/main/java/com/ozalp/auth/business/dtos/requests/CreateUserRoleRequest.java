package com.ozalp.auth.business.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRoleRequest {

    private int userProfileId;

    private int roleId;

}
