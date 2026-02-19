package com.ozalp.training.business.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Organization {

    private int id;

    private UserProfile owner;

    private String name;

    private String logoUrl;

}
