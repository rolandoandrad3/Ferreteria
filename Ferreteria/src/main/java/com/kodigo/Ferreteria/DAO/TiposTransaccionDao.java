package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.TiposTransaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposTransaccionDao extends JpaRepository<TiposTransaccionEntity, Integer> {
}
