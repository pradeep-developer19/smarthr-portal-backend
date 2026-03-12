package com.pradeep.samrthrportal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.pradeep.samrthrportal.dto.AuthResponseDTO;
import com.pradeep.samrthrportal.dto.LoginRequestDTO;
import com.pradeep.samrthrportal.entity.User;
import com.pradeep.samrthrportal.repository.UserRepository;
import com.pradeep.samrthrportal.security.jwt.JwtService;
import com.pradeep.samrthrportal.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private JwtService jwtService;

        @Autowired
        private UserRepository userRepository;

        @Override
        public AuthResponseDTO login(LoginRequestDTO request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

    // Fetch user from DB
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

    // Generate token
        String token = jwtService.generateToken(
                user.getEmail(),
                user.getRole().name()
        );

    // Return full response (because your DTO requires 3 params)
        return new AuthResponseDTO(
                token,
                user.getRole().name(),
                user.getEmail()
        );
        }
}