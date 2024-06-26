package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.OrdenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenDao extends JpaRepository<OrdenEntity, Long> {
}
