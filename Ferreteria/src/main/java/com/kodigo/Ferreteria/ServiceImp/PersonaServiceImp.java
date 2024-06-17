package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.PersonaDao;
import com.kodigo.Ferreteria.Service.PersonaService;
import com.kodigo.Ferreteria.entity.PersonaEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public PersonaEntity updatePersona(PersonaEntity persona) {
        return null;
    }

    @Override
    public void deletePersona(Integer id) {personaDao.deleteById(id);

    }
}
