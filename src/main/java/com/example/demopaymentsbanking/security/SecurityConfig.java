package com.example.demopaymentsbanking.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails client1 = User.withUsername("NTesla")
                .password(passwordEncoder().encode("Nikola999"))
                .roles("USER")
                .build();

        UserDetails client2 = User.withUsername("MScorsese")
                .password(passwordEncoder().encode("Martin999"))
                .roles("USER")
                .build();

        UserDetails client3 = User.withUsername("RLyotta")
                .password(passwordEncoder().encode("Ray999"))
                .roles("USER")
                .build();

        UserDetails employee1 = User.withUsername("QTarantino")
                .password(passwordEncoder().encode("Quentin999"))
                .roles("ADMIN")
                .build();

        UserDetails employee2 = User.withUsername("HPotter")
                .password(passwordEncoder().encode("Harry999"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(client1, client2, client3, employee1, employee2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
