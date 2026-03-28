package com.ozalp.organization.config;

import com.ozalp.organization.business.services.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InitialDb {

    private final OrganizationService organizationService;

    @Bean
    public ApplicationRunner initialAdmin() {
        return args -> {
            organizationService.createRootOrganization();
        };
    }
}