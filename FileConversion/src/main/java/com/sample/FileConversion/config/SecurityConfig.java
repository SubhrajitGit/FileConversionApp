package com.sample.FileConversion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return  http.authorizeHttpRequests(registry->{
            registry.requestMatchers("/home").permitAll();
            registry.requestMatchers("/api/v1/admin/**").hasRole("ADMIN");
            registry.requestMatchers("/api/vq/user/**").hasRole("USER");
            registry.anyRequest().authenticated();
        })
                .formLogin(formLogin -> formLogin.permitAll())
                .build();
    }
}
