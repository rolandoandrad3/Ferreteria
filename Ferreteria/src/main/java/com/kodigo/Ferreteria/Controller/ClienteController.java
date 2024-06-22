package com.kodigo.Ferreteria.Controller;

import com.kodigo.Ferreteria.Service.CategoriaService;
import com.kodigo.Ferreteria.Service.ClienteService;
import com.kodigo.Ferreteria.entity.CategoriaEntity;
import com.kodigo.Ferreteria.entity.ClienteEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listCliente") //http://localhost:8080/cliente/listCliente
    public List<ClienteEntity> listAllClientes(){
        return clienteService.listAllClientes();
    }


    @PostMapping("/addCliente") //http://localhost:8080/cliente/addCliente
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteEntity creatCategoria(@RequestBody ClienteEntity cliente)
    {
        return clienteService.createCliente(cliente);
    }
    //need to implement update
    @PutMapping("/{id}")
    public ResponseEntity<ClienteEntity> updateCliente(@PathVariable Long id, @RequestBody ClienteEntity clienteEntity) {
        clienteEntity.setId(id);
        try {
            ClienteEntity updatedCliente = clienteService.updateCliente(clienteEntity);
            return ResponseEntity.ok(updatedCliente);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/deleteCliente/{id}")//http://localhost:8080/cliente/deleteCliente/6
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCliente(@PathVariable Integer id){clienteService.deleteCliente(id);}
}
