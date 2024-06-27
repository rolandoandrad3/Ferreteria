package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.TiposPagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposPagoDao extends JpaRepository<TiposPagoEntity, Integer> {
}
