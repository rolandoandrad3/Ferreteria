package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorDao extends JpaRepository<ProveedorEntity, Integer> {
}
