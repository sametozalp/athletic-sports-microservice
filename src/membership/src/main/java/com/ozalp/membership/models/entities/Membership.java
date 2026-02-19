package com.ozalp.membership.models.entities;

import com.ozalp.athletic_sports.models.enums.MembershipStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "memberships")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Membership extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile userProfile;

    @Column(nullable = false)
    private LocalDateTime joined_at;

    @Column
    private LocalDateTime left_at;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MembershipStatus status;

    @PrePersist
    private void onCreate() {
        this.status = MembershipStatus.ACTIVE;
    }

}