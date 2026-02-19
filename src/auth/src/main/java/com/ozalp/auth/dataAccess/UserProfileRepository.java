package com.ozalp.auth.dataAccess;

import com.ozalp.auth.models.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
}
