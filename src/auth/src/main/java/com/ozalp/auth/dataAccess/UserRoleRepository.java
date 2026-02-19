package com.ozalp.auth.dataAccess;

import com.ozalp.auth.models.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}
