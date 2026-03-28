package com.ozalp.auth.business.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuickStartRequest {

    private String username;

    private String email;

    private String password;

    private int organizationId;
}
