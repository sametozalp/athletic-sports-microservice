package com.ozalp.membership.models.entities;

import com.ozalp.membership.models.enums.MembershipStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ozalp.models.entites.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "memberships")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Membership extends BaseEntity {

    @Column(nullable = false)
    private int organizationId;

    @Column(nullable = false)
    private int userProfileId;

    @Column(nullable = false)
    private LocalDateTime joinedAt;

    @Column
    private LocalDateTime leftAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MembershipStatus status = MembershipStatus.ACTIVE;

}