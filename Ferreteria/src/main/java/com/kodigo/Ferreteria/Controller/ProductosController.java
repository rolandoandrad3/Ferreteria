package com.kodigo.Ferreteria.Controller;

import com.kodigo.Ferreteria.Service.ProductosService;
import com.kodigo.Ferreteria.entity.ProductosEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductosService productosService;
    @GetMapping
    public List<ProductosEntity> listAllProductos() {
        return productosService.listProductos();
    }

    @PostMapping
    public ProductosEntity createProducto(@RequestBody ProductosEntity productoEntity) {
        return productosService.createProductos(productoEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductosEntity> updateProducto(@PathVariable Long id, @RequestBody ProductosEntity productoEntity) {
        productoEntity.setId(id);
        try {
            ProductosEntity updatedProducto = productosService.updateProductos(productoEntity);
            return ResponseEntity.ok(updatedProducto);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        productosService.deleteProductos(id);
        return ResponseEntity.noContent().build();
    }
}
