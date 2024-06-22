package com.kodigo.Ferreteria.Controller;

import com.kodigo.Ferreteria.Service.PagoService;
import com.kodigo.Ferreteria.entity.PagoEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pago")
public class PagoController {

    @Autowired
    private PagoService pagoService;
    @GetMapping("/listPago")
    public List<PagoEntity> listAllPagos() {
        return pagoService.listPago();
    }

    @PostMapping("/createPago/{pago}")
    public PagoEntity createPago(@PathVariable PagoEntity pago) {
        return pagoService.createPago(pago);
    }

    @PutMapping("/UpdatePago/{id}")
    public ResponseEntity<PagoEntity> updatePago(@PathVariable Long id, @RequestBody PagoEntity pagoEntity) {
        pagoEntity.setId(id);
        try {
            PagoEntity updatedPago = pagoService.updatePago(pagoEntity);
            return ResponseEntity.ok(updatedPago);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletePago/{id}")
    public ResponseEntity<Void> deletePago(@PathVariable Long id) {
        pagoService.deletePago(Math.toIntExact(id));
        return ResponseEntity.noContent().build();
    }
}
