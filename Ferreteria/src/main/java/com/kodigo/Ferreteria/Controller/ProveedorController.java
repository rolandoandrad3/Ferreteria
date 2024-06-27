package com.kodigo.Ferreteria.Controller;

import com.kodigo.Ferreteria.Service.ProveedorService;
import com.kodigo.Ferreteria.entity.ProveedorEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;
    @GetMapping("/listProveedores") //http://localhost:8080/proveedor/listProveedores
    public List<ProveedorEntity> listAllProveedores() {
        return proveedorService.listProveedor();
    }

    @PostMapping("/createProveedor") //http://localhost:8080/proveedor
    public ProveedorEntity createProveedor(@RequestBody ProveedorEntity proveedorEntity) {
        return proveedorService.createProveedor(proveedorEntity);
    }

    @PutMapping("/updateProveedor/{id}") //http://localhost:8080/proveedor/updateProveedor/6
    public ResponseEntity<ProveedorEntity> updateProveedor(@PathVariable Long id, @RequestBody ProveedorEntity proveedorEntity) {
        proveedorEntity.setId(id);
        try {
            ProveedorEntity updatedProveedor = proveedorService.updateProveedor(proveedorEntity);
            return ResponseEntity.ok(updatedProveedor);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}") //http://localhost:8080/proveedor/delete/6
    public ResponseEntity<Void> deleteProveedor(@PathVariable Long id) {
        proveedorService.deleteProveedor(Math.toIntExact(id));
        return ResponseEntity.noContent().build();
    }
}
