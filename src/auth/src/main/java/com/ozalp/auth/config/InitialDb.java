package com.ozalp.auth.config;

import com.ozalp.auth.business.services.AuthService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialDb {

    private final AuthService authService;

    public InitialDb(AuthService authService) {
        this.authService = authService;
    }

    @Bean
    public ApplicationRunner initialAdmin() {
        return args -> {
            authService.createRootAdmin();
        };
    }
}