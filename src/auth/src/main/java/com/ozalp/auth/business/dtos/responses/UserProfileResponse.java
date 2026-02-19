package com.ozalp.auth.business.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileResponse {

    private int id;

    private String name;

    private String surname;
}
