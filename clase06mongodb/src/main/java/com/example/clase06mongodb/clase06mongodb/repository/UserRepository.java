package com.example.clase06mongodb.clase06mongodb.repository;

import com.example.clase06mongodb.clase06mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

  Optional<User> findByUsername(String username);

  default boolean existsUserByUsername(String username){
    return  findByUsername(username).isPresent();
  }

}
