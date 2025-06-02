package com.example.clase06mongodb.clase06mongodb.controller;

import com.example.clase06mongodb.clase06mongodb.dto.ProductoDTO;
import com.example.clase06mongodb.clase06mongodb.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listarTodos(){
        List<ProductoDTO> lista = productoService.listarProductos();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> crearProducto(@RequestBody ProductoDTO productoDTO){
        System.out.println(productoDTO);
        ProductoDTO productoCreado = productoService.crearProducto(productoDTO);
        return ResponseEntity.ok(productoCreado);
    }
}
