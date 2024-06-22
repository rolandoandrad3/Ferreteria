package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.PersonaDao;
import com.kodigo.Ferreteria.Service.PersonaService;
import com.kodigo.Ferreteria.entity.PersonaEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service

public class PersonaServiceImp implements PersonaService {
    @Autowired
    public PersonaDao personaDao;

    @Override
    public List<PersonaEntity> listarPersonas() {
        return personaDao.findAll();
    }

    @Override
    public PersonaEntity createPersona(PersonaEntity persona) {
        return personaDao.save(persona);
    }

    @Override
    public PersonaEntity updatePersona(PersonaEntity personaEntity) {
        Optional<PersonaEntity> optionalPersona = personaDao.findById(Math.toIntExact(personaEntity.getId()));
        if (optionalPersona.isPresent()) {
            PersonaEntity existingPersona = optionalPersona.get();
            existingPersona.setNombre(personaEntity.getNombre());
            existingPersona.setApellido(personaEntity.getApellido());
            existingPersona.setDireccion(personaEntity.getDireccion());
            existingPersona.setTelefono(personaEntity.getTelefono());
            existingPersona.setCorreo(personaEntity.getCorreo());
            existingPersona.setFechaNacimiento(personaEntity.getFechaNacimiento());
            existingPersona.setGenero(personaEntity.getGenero());
            existingPersona.setDocumento(personaEntity.getDocumento());
            existingPersona.setTipoPersona(personaEntity.getTipoPersona());
            existingPersona.setEstado(personaEntity.getEstado());
            existingPersona.setFechaModificacion(LocalDate.now());
            existingPersona.setUsuarioModificacion(personaEntity.getUsuarioModificacion());
            existingPersona.setRol(personaEntity.getRol());
            existingPersona.setEstadoCuenta(personaEntity.getEstadoCuenta());
            return personaDao.save(existingPersona);
        } else {
            throw new EntityNotFoundException("La persona con id " + personaEntity.getId() + " no existe.");
        }
    }

    @Override
    public void deletePersona(Integer id) {personaDao.deleteById(id);

    }
}
