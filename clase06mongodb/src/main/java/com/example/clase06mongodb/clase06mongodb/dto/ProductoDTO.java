package com.example.clase06mongodb.clase06mongodb.dto;

import com.example.clase06mongodb.clase06mongodb.model.enums.Color;
import lombok.Data;

import java.util.Set;

@Data

public class ProductoDTO {
    private String id;
    private String nombre;
    private double precio;
    private boolean enStock;
    private Set<Color> colores;
}
