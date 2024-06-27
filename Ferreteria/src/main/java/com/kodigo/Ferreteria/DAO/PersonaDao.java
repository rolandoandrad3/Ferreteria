package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaDao extends JpaRepository<PersonaEntity, Integer> {
}
