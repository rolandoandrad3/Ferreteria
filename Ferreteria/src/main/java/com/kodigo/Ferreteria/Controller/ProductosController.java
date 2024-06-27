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
    @GetMapping("/listProductos")
    public List<ProductosEntity> listAllProductos() {
        return productosService.listProductos();
    }

    @PostMapping("/createProducto")
    public ProductosEntity createProducto(@RequestBody ProductosEntity productoEntity) {
        return productosService.createProductos(productoEntity);
    }

    @PutMapping("updateProducto/{id}")
    public ResponseEntity<ProductosEntity> updateProducto(@PathVariable Long id, @RequestBody ProductosEntity productoEntity) {
        productoEntity.setId(id);
        try {
            ProductosEntity updatedProducto = productosService.updateProductos(productoEntity);
            return ResponseEntity.ok(updatedProducto);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("deleteProducto/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        productosService.deleteProductos(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar por nombre del producto
    @GetMapping("/nombre/{nombre}")
    public List<ProductosEntity> findByNombre(@PathVariable String nombre) {
        return productosService.findByNombre(nombre);
    }

    // Buscar por categoría del producto
    @GetMapping("/categoria/{categoriaId}")
    public List<ProductosEntity> findByCategoriaId(@PathVariable Long categoriaId) {
        return productosService.findByCategoriaId(categoriaId);
    }

    // Buscar por precio mayor a un valor específico
    @GetMapping("/precio/{precio}")
    public List<ProductosEntity> findByPrecioGreaterThan(@PathVariable Double precio) {
        return productosService.findByPrecioGreaterThan(precio);
    }

}
