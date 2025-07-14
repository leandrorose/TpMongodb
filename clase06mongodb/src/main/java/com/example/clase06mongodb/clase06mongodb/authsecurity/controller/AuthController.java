package com.example.clase06mongodb.clase06mongodb.authsecurity.controller;


import com.example.clase06mongodb.clase06mongodb.authsecurity.dto.AuthRequest;
import com.example.clase06mongodb.clase06mongodb.authsecurity.dto.AuthResponse;
import com.example.clase06mongodb.clase06mongodb.authsecurity.dto.UserRegisterDTO;
import com.example.clase06mongodb.clase06mongodb.authsecurity.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;
  @PostMapping("/register")
  public ResponseEntity<AuthResponse> register(@Valid @RequestBody UserRegisterDTO request) {
    return ResponseEntity.ok(authService.register(request));}
  @PostMapping("/login")
  public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest request) {
    return ResponseEntity.ok(authService.authenticate(request));   }}
