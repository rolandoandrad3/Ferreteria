package com.kodigo.Ferreteria.Controller;

import com.kodigo.Ferreteria.Service.EmpleadoService;
import com.kodigo.Ferreteria.entity.CategoriaEntity;
import com.kodigo.Ferreteria.entity.EmpleadoEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/empleado")

public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/listEmpleados") //http://localhost:8080/empleado/listEmpleados
    public List<EmpleadoEntity> listAllEmpleados(){
        return empleadoService.listAllEmpleados();
    }


    @PostMapping("/addEmpleado") //http://localhost:8080/empleado/addEmpleado
    @ResponseStatus(HttpStatus.CREATED)
    public EmpleadoEntity createEmpleado(@RequestBody EmpleadoEntity empleado)
    {
        return empleadoService.createEmpleado(empleado);
    }

    @PutMapping("/updateEmpleado/{id}") //http://localhost:8080/empleado/updateEmpleado/4
    public ResponseEntity<EmpleadoEntity> updateEmpleado(@PathVariable Long id, @RequestBody EmpleadoEntity empleadoEntity) {
        empleadoEntity.setId(id);
        try {
            EmpleadoEntity updateEmpleado = empleadoService.updateEmpleado(empleadoEntity);
            return ResponseEntity.ok(updateEmpleado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteEmpleado/{id}")//http://localhost:8080/empleado/deleteEmpleado/4
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmpleado(@PathVariable Integer id){empleadoService.deleteEmpleado(id);}

    // Buscar por apellido
    @GetMapping("/apellido/{apellido}")
    public List<EmpleadoEntity> findByApellido(@PathVariable String apellido) {
        return empleadoService.findByApellido(apellido);
    }

    // Buscar por DUI
    @GetMapping("/dui/{dui}")
    public List<EmpleadoEntity> findByDui(@PathVariable String dui) {
        return empleadoService.findByDui(dui);
    }

    // Buscar por fecha de contratación
    @GetMapping("/fechaContratacion/{fechaContratacion}")
    public List<EmpleadoEntity> findByFechaContratacion(@PathVariable LocalDate fechaContratacion) {
        return empleadoService.findByFechaContratacion(fechaContratacion);
    }

    // Buscar por cargo
    @GetMapping("/cargo/{cargo}")
    public List<EmpleadoEntity> findByCargo(@PathVariable String cargo) {
        return empleadoService.findByCargo(cargo);
    }
}
