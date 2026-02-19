package com.ozalp.auth.business.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    private String username;

    private String email;

    private String password;
}
