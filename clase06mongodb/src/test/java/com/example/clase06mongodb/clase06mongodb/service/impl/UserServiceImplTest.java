package com.example.clase06mongodb.clase06mongodb.service.impl;

import com.example.clase06mongodb.clase06mongodb.dto.UserDTO;
import com.example.clase06mongodb.clase06mongodb.mapper.GenericMapper;
import com.example.clase06mongodb.clase06mongodb.model.User;
import com.example.clase06mongodb.clase06mongodb.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    private UserRepository userRepository;
    private GenericMapper genericMapper;
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        genericMapper = mock(GenericMapper.class);
        userService = new UserServiceImpl(userRepository, genericMapper);
    }

    @Test
    void createUser_deberiaGuardarYRetornarUserDTO() {
        UserDTO dto = new UserDTO();
        dto.setUsername("testuser");
        User user = new User();
        user.setUsername("testuser");

        when(genericMapper.toEntity(dto, User.class)).thenReturn(user);
        when(userRepository.existsByUsername("testuser")).thenReturn(false);
        when(userRepository.save(user)).thenReturn(user);
        when(genericMapper.toDTO(user, UserDTO.class)).thenReturn(dto);

        UserDTO resultado = userService.createUser(dto);

        assertNotNull(resultado);
        assertEquals("testuser", resultado.getUsername());
        verify(userRepository).save(user);
    }

    @Test
    void createUser_deberiaLanzarExcepcionSiExisteUsername() {
        UserDTO dto = new UserDTO();
        dto.setUsername("testuser");
        User user = new User();
        user.setUsername("testuser");

        when(genericMapper.toEntity(dto, User.class)).thenReturn(user);
        when(userRepository.existsByUsername("testuser")).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> userService.createUser(dto));
        verify(userRepository, never()).save(any());
    }
}

