package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesDao extends JpaRepository<ClienteEntity, Integer> {
}
