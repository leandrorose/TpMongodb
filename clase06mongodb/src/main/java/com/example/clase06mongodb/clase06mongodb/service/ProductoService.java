package com.example.clase06mongodb.clase06mongodb.service;

import com.example.clase06mongodb.clase06mongodb.dto.ProductoDTO;

import java.util.List;

public interface ProductoService {
    ProductoDTO crearProducto(ProductoDTO productoDTO);
    ProductoDTO obtenerProductoPorId(String id);
    List<ProductoDTO> listarProductos();
    void eliminarProducto(String id);
    ProductoDTO obtenerProductoPorNombre(String nombre);
    List<ProductoDTO> obtenerProductosPorColor(String color);
    List<ProductoDTO> obtenerProductosPorPrecio(double precio);

}
