package com.example.chat_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Désactive la protection CSRF (Cross-Site Request Forgery)
                .csrf(csrf -> csrf.disable())
                // Autorise les requêtes cross-origin
                .cors(cors -> cors.disable())
                // Configure les autorisations
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/ws/**").permitAll()
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}