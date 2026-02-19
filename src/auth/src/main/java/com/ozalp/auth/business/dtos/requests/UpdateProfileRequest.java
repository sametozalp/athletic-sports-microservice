package com.ozalp.auth.business.dtos.requests;

import com.ozalp.auth.models.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateProfileRequest {

    private int profileId;

    private String name;

    private String surname;

    private String phone;

    private LocalDate dateOfBirth;

    private Gender gender;
}
