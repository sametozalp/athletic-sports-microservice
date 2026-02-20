package com.ozalp.membership.models.entities;

import com.ozalp.membership.models.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ozalp.models.entites.BaseEntity;

@Entity
@Table(name = "membership_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MembershipRequest extends BaseEntity {

    @Column(nullable = false)
    private int userProfileId;

    @Column(nullable = false)
    private int organizationId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestStatus status = RequestStatus.PENDING;
    ;

}