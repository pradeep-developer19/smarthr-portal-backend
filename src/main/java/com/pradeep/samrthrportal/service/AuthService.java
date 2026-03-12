package com.pradeep.samrthrportal.service;

import com.pradeep.samrthrportal.dto.AuthResponseDTO;
import com.pradeep.samrthrportal.dto.LoginRequestDTO;

public interface AuthService {

    AuthResponseDTO login(LoginRequestDTO request);


}