package com.ozalp.auth.models.entities;

import com.ozalp.auth.models.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ozalp.models.entites.BaseEntity;

import java.time.LocalDate;

@Entity
@Table(name = "user_profiles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserProfile extends BaseEntity {

    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private Auth auth;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String phone;

    @Column
    private LocalDate dateOfBirth;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
