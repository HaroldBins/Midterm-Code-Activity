package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/contacts", "/contacts/add", "/contacts/update", "/contacts/delete").permitAll() // Allow these endpoints
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable())  // Disable CSRF protection for form submission
                .oauth2Login(httpSecurityOAuth2LoginConfigurer -> {}); // Replacing deprecated method

        return http.build();
    }
}
