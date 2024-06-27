package com.kodigo.Ferreteria.Controller;

import com.kodigo.Ferreteria.Service.TiposTransaccionService;
import com.kodigo.Ferreteria.entity.TiposTransaccionEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiposTransaccion")
public class TiposTransaccionController {

    @Autowired
    private TiposTransaccionService tiposTransaccionService;

    @GetMapping("/listTiposTransaccion")
    public List<TiposTransaccionEntity> listAllTiposTransaccion() {
        return tiposTransaccionService.listTiposTransaccion();
    }

    @PostMapping("/createTipoTransaccion")
    public TiposTransaccionEntity createTiposTransaccion(@RequestBody TiposTransaccionEntity transaccion) {
        return tiposTransaccionService.createTiposTransaccion(transaccion);
    }

    @PutMapping("/updateTipoTransaccion/{id}")
    public ResponseEntity<TiposTransaccionEntity> updateTiposTransaccion(@PathVariable Long id, @RequestBody TiposTransaccionEntity tiposTransaccionEntity) {
        tiposTransaccionEntity.setId(id);
        try {
            TiposTransaccionEntity updatedTiposTransaccion = tiposTransaccionService.updateTiposTransaccion(tiposTransaccionEntity);
            return ResponseEntity.ok(updatedTiposTransaccion);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("deleteTipoTransaccion/{id}")
    public ResponseEntity<Void> deleteTiposTransaccion(@PathVariable Long id) {
        tiposTransaccionService.deleteTiposTransaccion(Math.toIntExact(id));
        return ResponseEntity.noContent().build();
    }
}
