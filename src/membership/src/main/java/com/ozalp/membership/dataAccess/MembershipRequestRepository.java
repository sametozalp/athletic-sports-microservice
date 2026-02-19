package com.ozalp.membership.dataAccess;

import com.ozalp.membership.models.entities.MembershipRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRequestRepository extends JpaRepository<MembershipRequest, Integer> {
}
