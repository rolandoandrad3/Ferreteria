package com.kodigo.Ferreteria.Controller;

import com.kodigo.Ferreteria.Service.DetalleFacturaService;
import com.kodigo.Ferreteria.entity.ClienteEntity;
import com.kodigo.Ferreteria.entity.DetalleFacturaEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalleFactura")
public class DetalleFacturaController {

    @Autowired
    private DetalleFacturaService detalleFacturaService;

    @GetMapping("/listFacturas") //http://localhost:8080/cliente/listCliente
    public List<DetalleFacturaEntity> listDetalleFactura(){
        return detalleFacturaService.listDetalleFactura();
    }


    @PostMapping("/addFactura") //http://localhost:8080/cliente/addCliente
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleFacturaEntity createDetalleFactura(@RequestBody DetalleFacturaEntity detalleFactura)
    {
        return detalleFacturaService.createDetalleFactura(detalleFactura);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DetalleFacturaEntity> updateDetalleFactura(@PathVariable Long id, @RequestBody DetalleFacturaEntity detalleFacturaEntity) {
        detalleFacturaEntity.setId(id);
        try {
            DetalleFacturaEntity updatedDetalle = detalleFacturaService.updateDetalleFactura(detalleFacturaEntity);
            return ResponseEntity.ok(updatedDetalle);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteFactura/{id}")//http://localhost:8080/cliente/deleteCliente/6
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDetalleFactura(@PathVariable Integer id){detalleFacturaService.deleteDetalleFactura(id);}
}

