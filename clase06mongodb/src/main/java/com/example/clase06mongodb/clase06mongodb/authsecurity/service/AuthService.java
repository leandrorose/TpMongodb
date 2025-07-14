package com.example.clase06mongodb.clase06mongodb.authsecurity.service;


import com.example.clase06mongodb.clase06mongodb.authsecurity.dto.AuthRequest;
import com.example.clase06mongodb.clase06mongodb.authsecurity.dto.AuthResponse;
import com.example.clase06mongodb.clase06mongodb.authsecurity.dto.UserRegisterDTO;

public interface AuthService {
    AuthResponse register(UserRegisterDTO request);
    AuthResponse authenticate(AuthRequest request);
}