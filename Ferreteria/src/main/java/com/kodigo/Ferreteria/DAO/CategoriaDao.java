package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaDao extends JpaRepository<CategoriaEntity, Integer> {

}
