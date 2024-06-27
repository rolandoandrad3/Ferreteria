package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.TransaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionDao extends JpaRepository<TransaccionEntity, Integer> {
}
