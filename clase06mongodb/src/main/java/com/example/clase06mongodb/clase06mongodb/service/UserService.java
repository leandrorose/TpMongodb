package com.example.clase06mongodb.clase06mongodb.service;

import com.example.clase06mongodb.clase06mongodb.dto.UserDTO;

import java.util.List;

public interface UserService {
  UserDTO createUser(UserDTO user);
  List<UserDTO> getAllUsers();
  UserDTO updateUser(String id, UserDTO user);
  void  deleteUser(String id);

}
