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
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerPorId(@PathVariable String id) {
        ProductoDTO producto = productoService.obtenerProductoPorId(id);
        return ResponseEntity.ok(producto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable String id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizarProducto(@PathVariable String id, @RequestBody ProductoDTO productoDTO) {
        productoDTO.setId(id);
        ProductoDTO actualizado = productoService.crearProducto(productoDTO); // O implementar un método update específico
        return ResponseEntity.ok(actualizado);
    }

    @GetMapping("/buscar/nombre")
    public ResponseEntity<ProductoDTO> obtenerPorNombre(@RequestParam String nombre) {
        ProductoDTO producto = productoService.obtenerProductoPorNombre(nombre);
        return ResponseEntity.ok(producto);
    }
}
