package com.github.narh.batch;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
    @Value("${spring.profiles.active}")
    String activeProfile;

    @Bean
    PasswordEncoder passwordEncoder() {
        switch (activeProfile) {
            case "local":
            case "intra":
                return NoOpPasswordEncoder.getInstance();
            default:
                return new BCryptPasswordEncoder();
        }
    }
}