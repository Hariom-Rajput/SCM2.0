package com.scm.hari.scm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.scm.hari.scm.services.implementation.CustomUserDetailsService;

@Configuration
public class SecurityConfig {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}




// M-1: to create In-Memory users
/*
 * 
 * @Bean
 * public UserDetailsService userDetailsService () { // In-built service
 * var user1 = User // uses UserDetail class
 * .withDefaultPasswordEncoder()
 * .username("hariom")
 * .password("hariom")
 * .roles("ADMIN","USER")
 * .build();
 * var inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1); // to
 * create In-Memory user
 * return inMemoryUserDetailsManager;
 * }
 */