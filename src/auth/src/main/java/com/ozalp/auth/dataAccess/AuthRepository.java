package com.ozalp.auth.dataAccess;

import com.ozalp.auth.models.entities.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth, Integer> {
}
