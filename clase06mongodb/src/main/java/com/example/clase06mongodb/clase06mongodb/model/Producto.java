package com.example.clase06mongodb.clase06mongodb.model;

import com.example.clase06mongodb.clase06mongodb.model.enums.Color;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "productos")
public class    Producto {
    @Id
    private String id;
    @NotBlank
    private String nombre;
    private double precio;
    private boolean enStock;
    private Set<Color> colores;
    


}
