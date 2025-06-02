package com.example.clase06mongodb.clase06mongodb.repository;

import com.example.clase06mongodb.clase06mongodb.model.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ProductoRepository extends MongoRepository<Producto,String> {
 Optional<Producto> findByNombre(String nombre);
}
