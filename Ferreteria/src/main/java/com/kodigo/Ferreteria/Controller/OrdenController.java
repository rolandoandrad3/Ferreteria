package com.kodigo.Ferreteria.Controller;

import com.kodigo.Ferreteria.Service.OrdenService;
import com.kodigo.Ferreteria.entity.OrdenEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {
    @Autowired
    private OrdenService ordenService;

    @GetMapping("/listOrdenes")
    public List<OrdenEntity> findAll() {
        return ordenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenEntity> findById(@PathVariable Integer id) {
        OrdenEntity orden = ordenService.findById(id);
        if (orden == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orden);
    }

    @PostMapping
    public OrdenEntity nuevaOrden(@RequestBody OrdenEntity orden) {
        return ordenService.nuevaOrden(orden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenEntity> updateOrden(@PathVariable Integer id, @RequestBody OrdenEntity orden) {
        try {
            orden.setId(id.longValue());
            OrdenEntity updatedOrden = ordenService.updateOrden(orden);
            return ResponseEntity.ok(updatedOrden);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        OrdenEntity existingOrden = ordenService.findById(id);
        if (existingOrden == null) {
            return ResponseEntity.notFound().build();
        }
        ordenService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar por fecha
    @GetMapping("/buscarFecha/{fecha}")
    public List<OrdenEntity> findByFecha(@PathVariable String fecha) {
        return ordenService.findByFecha(fecha);
    }

    // Buscar por empleado
    @GetMapping("/empleado/{empleadoId}")
    public List<OrdenEntity> findByEmpleado(@PathVariable Long empleadoId) {
        return ordenService.findByEmpleado(empleadoId);
    }

    // Buscar por categoría de producto
    @GetMapping("/categoria/{categoriaId}")
    public List<OrdenEntity> findByCategoriaProducto(@PathVariable Long categoriaId) {
        return ordenService.findByCategoriaProducto(categoriaId);
    }
}
