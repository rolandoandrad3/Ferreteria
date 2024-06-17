package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.PagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoDao extends JpaRepository<PagoEntity, Integer> {
}
