package com.example.clase06mongodb.clase06mongodb.service.impl;

import com.example.clase06mongodb.clase06mongodb.dto.ProductoDTO;
import com.example.clase06mongodb.clase06mongodb.mapper.ProductoMapper;
import com.example.clase06mongodb.clase06mongodb.model.Producto;
import com.example.clase06mongodb.clase06mongodb.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductoServiceImplTest {

    private ProductoRepository productoRepository;
    private ProductoMapper productoMapper;
    private ProductoServiceImpl productoService;

    @BeforeEach
    void setUp() {
        productoRepository = mock(ProductoRepository.class);
        productoMapper = mock(ProductoMapper.class);
        productoService = new ProductoServiceImpl(productoRepository, productoMapper);
    }

    @Test
    void crearProducto_deberiaRetornarProductoDTO() {
        ProductoDTO dto = new ProductoDTO();
        Producto producto = new Producto();
        Producto productoGuardado = new Producto();
        ProductoDTO dtoGuardado = new ProductoDTO();

        when(productoMapper.toEntity(dto)).thenReturn(producto);
        when(productoRepository.save(producto)).thenReturn(productoGuardado);
        when(productoMapper.toDTO(productoGuardado)).thenReturn(dtoGuardado);

        ProductoDTO resultado = productoService.crearProducto(dto);

        assertNotNull(resultado);
        assertEquals(dtoGuardado, resultado);
        verify(productoRepository).save(producto);
    }
}
