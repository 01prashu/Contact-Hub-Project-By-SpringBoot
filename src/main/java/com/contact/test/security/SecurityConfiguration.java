package com.contact.test.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    UserDetailsService userDetailsService;
    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider()
    {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userDetailsService);
        return authenticationProvider;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws  Exception
    {

        httpSecurity.csrf(cs->cs.disable()).authorizeHttpRequests(auth->
                auth.requestMatchers("/user/**","/home","/register","/signup-handler" , "/css/**" ,"/fonts/**","/img/**","/js/**","/scss/**","/vendor/**" ,"/login","handle-signIn").permitAll().
                        anyRequest().authenticated()
        ).formLogin(form->form.loginPage("/login").loginProcessingUrl("/handle-signIn").defaultSuccessUrl("/home", true));
        return  httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return  new BCryptPasswordEncoder();
    }
}
