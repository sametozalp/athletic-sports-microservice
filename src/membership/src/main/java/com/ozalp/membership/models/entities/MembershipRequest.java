package com.ozalp.membership.models.entities;

import com.ozalp.athletic_sports.models.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "membership_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MembershipRequest extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserProfile userProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestStatus status;

    @PrePersist
    private void onCreate() {
        this.status = RequestStatus.PENDING;
    }

}