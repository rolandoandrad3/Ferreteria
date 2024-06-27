package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaDao extends JpaRepository<FacturaEntity, Integer> {
}
