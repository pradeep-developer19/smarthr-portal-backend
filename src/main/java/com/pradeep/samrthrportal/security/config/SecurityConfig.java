package com.pradeep.samrthrportal.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pradeep.samrthrportal.security.CustomUserDetailsService;
import com.pradeep.samrthrportal.security.jwt.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Autowired
    private com.pradeep.samrthrportal.exception.CustomAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private com.pradeep.samrthrportal.exception.CustomAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    // Password Encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Authentication Provider
    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    // Authentication Manager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // Security Filter Chain
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http
        .csrf(csrf -> csrf.disable())

        // 🔥 Stateless JWT
        .sessionManagement(session -> 
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )

        .authorizeHttpRequests(auth -> auth

            // Public APIs
            .requestMatchers("/api/auth/**").permitAll()

            // ADMIN only
            .requestMatchers("/api/admin/**")
                .hasRole("ADMIN")

            // HR only
            .requestMatchers("/api/hr/**")
                .hasAnyRole("ADMIN", "HR")

            // EMPLOYEE only
            .requestMatchers("/api/employee/**")
                .hasAnyRole("ADMIN", "HR", "EMPLOYEE")

            .anyRequest().authenticated()
        )

        // 🔥 ADD THIS BLOCK (VERY IMPORTANT)
        .exceptionHandling(exception -> exception
            .authenticationEntryPoint(authenticationEntryPoint)
            .accessDeniedHandler(accessDeniedHandler)
        )

        .authenticationProvider(authenticationProvider())

        .addFilterBefore(jwtAuthenticationFilter, 
                UsernamePasswordAuthenticationFilter.class);

    return http.build();
}
}