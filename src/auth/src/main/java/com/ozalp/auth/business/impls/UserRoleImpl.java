package com.ozalp.auth.business.impls;

import com.ozalp.auth.business.dtos.requests.CreateUserRoleRequest;
import com.ozalp.auth.business.services.RoleService;
import com.ozalp.auth.business.services.UserProfileService;
import com.ozalp.auth.business.services.UserRoleService;
import com.ozalp.auth.dataAccess.UserRoleRepository;
import com.ozalp.auth.models.entities.Role;
import com.ozalp.auth.models.entities.UserProfile;
import com.ozalp.auth.models.entities.UserRole;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleImpl implements UserRoleService {

    private final UserRoleRepository repository;
    private final RoleService roleService;
    private final UserProfileService userProfileService;

    @Override
    public UserRole findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User Role not found"));
    }

    @Override
    public UserRole save(UserRole userRole) {
        return repository.save(userRole);
    }

    @Override
    public void delete(int id) {
        UserRole userRole = findById(id);
        userRole.markAsDelete();
        repository.save(userRole);
    }

    @Override
    public void create(CreateUserRoleRequest request) {
        Role role = roleService.findById(request.getRoleId());
        UserProfile userProfile = userProfileService.findById(request.getUserProfileId());
        UserRole userRole = new UserRole(userProfile, role);
        repository.save(userRole);
    }
}
