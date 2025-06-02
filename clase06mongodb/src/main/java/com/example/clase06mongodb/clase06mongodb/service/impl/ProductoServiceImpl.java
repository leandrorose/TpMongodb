package com.example.clase06mongodb.clase06mongodb.service.impl;

import com.example.clase06mongodb.clase06mongodb.dto.ProductoDTO;
import com.example.clase06mongodb.clase06mongodb.mapper.ProductoMapper;
import com.example.clase06mongodb.clase06mongodb.model.Producto;
import com.example.clase06mongodb.clase06mongodb.repository.ProductoRepository;
import com.example.clase06mongodb.clase06mongodb.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDTO) {
        // Implementación del método para crear un producto
        Producto producto= productoMapper.toEntity(productoDTO);
        Producto productoGuardado=  productoRepository.save(producto);
        return productoMapper.toDTO(productoGuardado);

    }

    @Override
    public ProductoDTO obtenerProductoPorId(String id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontró el producto con id: " + id));
        // Si no lo encuentro tiro una excepcion.
        return productoMapper.toDTO(producto);
    }

    @Override
    public List<ProductoDTO> listarProductos() {
        return productoRepository.findAll().stream().map(productoMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void eliminarProducto(String id) {

    }

    @Override
    public ProductoDTO obtenerProductoPorNombre(String nombre) {
        return null;
    }

    @Override
    public List<ProductoDTO> obtenerProductosPorColor(String color) {
        return List.of();
    }

    @Override
    public List<ProductoDTO> obtenerProductosPorPrecio(double precio) {
        return List.of();
    }
}
