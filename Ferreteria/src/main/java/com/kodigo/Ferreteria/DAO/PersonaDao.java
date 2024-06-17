package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDao extends JpaRepository<PersonaEntity, Integer> {
}
