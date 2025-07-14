package com.example.clase06mongodb.clase06mongodb.service;

import com.example.clase06mongodb.clase06mongodb.dto.UserDTO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface UserService {
  UserDTO createUser(UserDTO dto);
  UserDTO getUserById(String id);
  List<UserDTO> getAllUsers();
  UserDTO updateUser( UserDTO dto);
  void deleteUser(String id);
  CompletableFuture<List<UserDTO>> getAllUsersAsync();
  void processUsersByIdList(List<String> ids);
}
