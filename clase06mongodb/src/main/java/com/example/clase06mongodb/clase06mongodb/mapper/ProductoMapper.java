package com.example.clase06mongodb.clase06mongodb.mapper;

import com.example.clase06mongodb.clase06mongodb.dto.ProductoDTO;
import com.example.clase06mongodb.clase06mongodb.model.Producto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public ProductoDTO toDTO(Producto producto) {
        return modelMapper.map(producto, ProductoDTO.class);
    }

    public Producto toEntity(ProductoDTO productoDTO) {
        return modelMapper.map(productoDTO, Producto.class);
    }
}
