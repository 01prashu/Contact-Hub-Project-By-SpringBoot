package com.contact.test.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class UserDefinedConfiguration {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/test", "/home", "/register", "/login", "/css/**", "/js/**", "/img/**" , "/fonts/**" , "/scss/**","/vendor/**").permitAll() // Allow public access to these endpoints and static resources
                        .anyRequest().authenticated() // Secure all other endpoints
                )
                .formLogin((form) -> form
                        .loginPage("/login") // Specify the custom login page
                        .permitAll() // Allow everyone to access the login page
                )
                .logout((logout) -> logout
                        .logoutSuccessUrl("/login?logout") // Redirect to login page after logout
                        .permitAll()
                );

        return http.build();
    }
}
