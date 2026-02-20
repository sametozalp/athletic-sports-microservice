package com.ozalp.auth.business.services;

import com.ozalp.auth.business.dtos.requests.CreateUserRoleRequest;
import com.ozalp.auth.models.entities.UserRole;
import org.ozalp.services.BaseService;

public interface UserRoleService extends BaseService<UserRole> {

    void create(CreateUserRoleRequest request);

}
