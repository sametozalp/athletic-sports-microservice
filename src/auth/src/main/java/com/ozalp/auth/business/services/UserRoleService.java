package com.ozalp.auth.business.services;

import com.ozalp.auth.business.dtos.requests.CreateUserRoleRequest;
import com.ozalp.auth.models.entities.UserRole;

public interface UserRoleService extends BaseService<UserRole> {

    void create(CreateUserRoleRequest request);

}
