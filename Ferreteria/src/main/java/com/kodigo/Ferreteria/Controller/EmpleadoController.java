package com.kodigo.Ferreteria.Controller;

import com.kodigo.Ferreteria.Service.EmpleadoService;
import com.kodigo.Ferreteria.entity.CategoriaEntity;
import com.kodigo.Ferreteria.entity.EmpleadoEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")

public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/listEmpleados") //http://localhost:8080/categoria/listCategorias
    public List<EmpleadoEntity> listAllEmpleados(){
        return empleadoService.listAllEmpleados();
    }


    @PostMapping("/addEmpleado") //http://localhost:8080/categoria/addCategoria
    @ResponseStatus(HttpStatus.CREATED)
    public EmpleadoEntity createEmpleado(@RequestBody EmpleadoEntity empleado)
    {
        return empleadoService.createEmpleado(empleado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoEntity> updateEmpleado(@PathVariable Long id, @RequestBody EmpleadoEntity empleadoEntity) {
        empleadoEntity.setId(id);
        try {
            EmpleadoEntity updateEmpleado = empleadoService.updateEmpleado(empleadoEntity);
            return ResponseEntity.ok(updateEmpleado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteEmpleado/{id}")//http://localhost:8080/categoria/deleteCategoria/6
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmpleado(@PathVariable Integer id){empleadoService.deleteEmpleado(id);}
}
