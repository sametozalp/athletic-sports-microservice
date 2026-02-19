package com.ozalp.organization.models.entities;

import com.ozalp.organization.models.enums.OrganizationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "organizations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Organization extends BaseEntity {

    @Column(nullable = false)
    private int ownerUserProfileId;

    @Column(nullable = false)
    private String name;

    @Column
    private String logoUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrganizationStatus status = OrganizationStatus.ACTIVE;

}