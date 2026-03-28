package com.ozalp.auth.business.impls;

import com.ozalp.auth.business.dtos.requests.CreateUserRoleRequest;
import com.ozalp.auth.business.services.RoleService;
import com.ozalp.auth.business.services.UserProfileService;
import com.ozalp.auth.business.services.UserRoleService;
import com.ozalp.auth.dataAccess.UserRoleRepository;
import com.ozalp.auth.models.entities.Role;
import com.ozalp.auth.models.entities.UserProfile;
import com.ozalp.auth.models.entities.UserRole;
import lombok.RequiredArgsConstructor;
import org.ozalp.managers.BaseImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleImpl extends BaseImpl<UserRole> implements UserRoleService {

    private final UserRoleRepository repository;
    private final RoleService roleService;
    private final UserProfileService userProfileService;

    @Override
    protected JpaRepository<UserRole, Integer> getRepository() {
        return repository;
    }

    @Override
    public void create(CreateUserRoleRequest request) {
        Role role = roleService.findById(request.getRoleId());
        UserProfile userProfile = userProfileService.findById(request.getUserProfileId());
        UserRole userRole = new UserRole(userProfile, role);
        repository.save(userRole);
    }
}
