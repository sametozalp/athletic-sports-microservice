package com.ozalp.membership.business.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfile {

    private int id;

    private String name;

    private String surname;

    private String email;
}
