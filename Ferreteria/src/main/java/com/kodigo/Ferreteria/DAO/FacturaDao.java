package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDao extends JpaRepository<FacturaEntity, Integer> {
}
