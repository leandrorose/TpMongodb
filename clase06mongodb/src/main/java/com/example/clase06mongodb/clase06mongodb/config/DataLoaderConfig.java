package com.example.clase06mongodb.clase06mongodb.config;

import com.example.clase06mongodb.clase06mongodb.authsecurity.dto.UserRegisterDTO;
import com.example.clase06mongodb.clase06mongodb.authsecurity.service.AuthServiceImpl;
import com.example.clase06mongodb.clase06mongodb.model.User;
import com.example.clase06mongodb.clase06mongodb.model.enums.Role;
import com.example.clase06mongodb.clase06mongodb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DataLoaderConfig implements CommandLineRunner {
    private final AuthServiceImpl authService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        log.info("Eliminando datos previos...");
        userRepository.deleteAll();

        log.info("Creando usuarios...");
        User ale = createUser("1000", "alej", "alejodomar@gmail.com", "12345678",Set.of(Role.USER));
        User cris = createUser("2000", "cris", "crisrobert@gmail.com", "12345678",Set.of(Role.USER));
        User runa = createUser("3000", "runa", "runalopez@gmail.com", "12345678",Set.of(Role.USER));
        User carlos  = createUser("4000", "carl", "carligarcia@gmail.com", "12345678",Set.of(Role.ADMIN));
        log.info("Usuarios creados: {}, {}, {}, {}", ale.getUsername(), cris.getUsername(), runa.getUsername(), carlos.getUsername());

    }

    private User createUser(String id, String username, String email, String password,Set<Role> roles) {
        com.example.clase06mongodb.clase06mongodb.authsecurity.dto.UserRegisterDTO dto = UserRegisterDTO.builder()
                .id(id)
                .username(username)
                .email(email)
                .password(password)
                .role(roles)
                .build();
        authService.register(dto);
        // Recuperar el usuario recién creado para devolverlo
        User user = userRepository.findByUsername(username).orElseThrow();
        log.debug("Usuario creado: {}", user);
        return user;
    }

}