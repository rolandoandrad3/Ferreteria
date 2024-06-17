package com.kodigo.Ferreteria.Service;

import com.kodigo.Ferreteria.entity.PersonaEntity;

import java.util.List;

public interface PersonaService {
    public List<PersonaEntity> listarPersonas();
    public PersonaEntity createPersona(PersonaEntity persona);
    public PersonaEntity updatePersona(PersonaEntity persona);
    public void deletePersona(Integer id);
}
