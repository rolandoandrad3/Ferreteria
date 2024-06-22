package com.kodigo.Ferreteria.Controller;

import com.kodigo.Ferreteria.Service.FacturaService;
import com.kodigo.Ferreteria.entity.FacturaEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<FacturaEntity> listAllFacturas() {
        return facturaService.listFactura();
    }

    @PostMapping
    public FacturaEntity createFactura(@RequestBody FacturaEntity facturaEntity) {
        return facturaService.createFactura(facturaEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturaEntity> updateFactura(@PathVariable Long id, @RequestBody FacturaEntity facturaEntity) {
        facturaEntity.setId(id);
        try {
            FacturaEntity updatedFactura = facturaService.updateFactura(facturaEntity);
            return ResponseEntity.ok(updatedFactura);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFactura(@PathVariable Long id) {
        facturaService.deleteFactura(Math.toIntExact(id));
        return ResponseEntity.noContent().build();
    }
}