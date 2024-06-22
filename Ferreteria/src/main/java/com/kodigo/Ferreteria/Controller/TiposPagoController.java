package com.kodigo.Ferreteria.Controller;

import com.kodigo.Ferreteria.Service.TiposPagoService;
import com.kodigo.Ferreteria.entity.TiposPagoEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiposPago")
public class TiposPagoController {

    @Autowired
    private TiposPagoService tiposPagoService;
    @GetMapping("/listTiposPago")
    public List<TiposPagoEntity> listAllTiposPago() {
        return tiposPagoService.listTiposPago();
    }

    @PostMapping("/createTipoPago")
    public TiposPagoEntity createTiposPago(@RequestBody TiposPagoEntity tiposPagoEntity) {
        return tiposPagoService.createTiposPago(tiposPagoEntity);
    }

    @PutMapping("/updateTipoPago/{id}")
    public ResponseEntity<TiposPagoEntity> updateTiposPago(@PathVariable Long id, @RequestBody TiposPagoEntity tiposPagoEntity) {
        tiposPagoEntity.setId(id);
        try {
            TiposPagoEntity updatedTiposPago = tiposPagoService.updateTiposPago(tiposPagoEntity);
            return ResponseEntity.ok(updatedTiposPago);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/deleteTipoPago/{id}")
    public ResponseEntity<Void> deleteTiposPago(@PathVariable Long id) {
        tiposPagoService.deleteTiposPago(Math.toIntExact(id));
        return ResponseEntity.noContent().build();
    }
}
