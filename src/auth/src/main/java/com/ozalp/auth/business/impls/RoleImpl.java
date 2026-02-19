package com.ozalp.auth.business.impls;

import com.ozalp.auth.business.dtos.requests.CreateRoleRequest;
import com.ozalp.auth.business.dtos.responses.RoleResponse;
import com.ozalp.auth.business.mappers.RoleMapper;
import com.ozalp.auth.business.services.RoleService;
import com.ozalp.auth.dataAccess.RoleRepository;
import com.ozalp.auth.models.entities.Role;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleImpl implements RoleService {

    private final RoleRepository repository;
    private final RoleMapper mapper;

    @Override
    public Role findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found"));
    }

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public void delete(int id) {
        Role role = findById(id);
        role.markAsDelete();
        repository.save(role);
    }

    @Override
    public Role findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public RoleResponse create(CreateRoleRequest request) {
        Role role = mapper.toEntity(request);
        return mapper.toResponse(repository.save(role));
    }
}
