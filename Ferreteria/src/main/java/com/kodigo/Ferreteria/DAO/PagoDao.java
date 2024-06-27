package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.PagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoDao extends JpaRepository<PagoEntity, Integer> {
}
