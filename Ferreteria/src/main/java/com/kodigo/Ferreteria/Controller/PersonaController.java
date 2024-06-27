package com.kodigo.Ferreteria.Controller;

import com.kodigo.Ferreteria.Service.PersonaService;
import com.kodigo.Ferreteria.entity.PersonaEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/listPersonas") //http://localhost:8080/personas/listPersonas
    public List<PersonaEntity> listarPersonas() {
        return personaService.listarPersonas();
    }

    @PostMapping("/addPersona") //http://localhost:8080/personas/addPersona
    public PersonaEntity createPersona(@RequestBody PersonaEntity personaEntity) {
        return personaService.createPersona(personaEntity);
    }

    @PutMapping("updatePersona/{id}") //http://localhost:8080/personas/updatePersona/6
    public ResponseEntity<PersonaEntity> updatePersona(@PathVariable Long id, @RequestBody PersonaEntity personaEntity) {
        personaEntity.setId(id);
        try {
            PersonaEntity updatedPersona = personaService.updatePersona(personaEntity);
            return ResponseEntity.ok(updatedPersona);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("deletePersona/{id}") //http://localhost:8080/personas/deletePersona/6
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        personaService.deletePersona(Math.toIntExact(id));
        return ResponseEntity.noContent().build();
    }
}

