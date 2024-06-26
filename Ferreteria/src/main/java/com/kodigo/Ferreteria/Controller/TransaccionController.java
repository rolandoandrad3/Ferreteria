package com.kodigo.Ferreteria.Controller;

import com.kodigo.Ferreteria.Service.TransaccionService;
import com.kodigo.Ferreteria.entity.TransaccionEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaccion")
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;

    @GetMapping
    public List<TransaccionEntity> listTransaccion() {
        return transaccionService.listTransaccion();
    }

    @PostMapping
    public TransaccionEntity createTransaccion(@RequestBody TransaccionEntity transaccionEntity) {
        return transaccionService.createTransaccion(transaccionEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransaccionEntity> updateTransaccion(@PathVariable Long id, @RequestBody TransaccionEntity transaccionEntity) {
        transaccionEntity.setId(id);
        try {
            TransaccionEntity updatedTransaccion = transaccionService.updateTransaccion(transaccionEntity);
            return ResponseEntity.ok(updatedTransaccion);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaccion(@PathVariable Long id) {
        transaccionService.deleteTransaccion(id);
        return ResponseEntity.noContent().build();
    }
}
