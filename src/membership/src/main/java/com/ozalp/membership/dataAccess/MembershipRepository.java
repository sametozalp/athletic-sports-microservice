package com.ozalp.membership.dataAccess;

import com.ozalp.membership.models.entities.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, Integer> {
}
