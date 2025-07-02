package com.example.clase06mongodb.clase06mongodb.authsecurity.service;


import com.example.clase06mongodb.clase06mongodb.authsecurity.dto.AuthRequest;
import com.example.clase06mongodb.clase06mongodb.authsecurity.dto.AuthResponse;
import com.example.clase06mongodb.clase06mongodb.dto.UserDTO;

public interface AuthService {
    AuthResponse register(UserDTO request);
    AuthResponse authenticate(AuthRequest request);
}