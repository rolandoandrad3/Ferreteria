package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.TiposTransaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiposTransaccionDao extends JpaRepository<TiposTransaccionEntity, Integer> {
}
