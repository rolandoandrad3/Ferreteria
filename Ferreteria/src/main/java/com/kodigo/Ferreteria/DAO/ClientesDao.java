package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClientesDao extends JpaRepository<ClienteEntity, Integer> {

    // Buscar por estado
    @Query("SELECT c FROM ClienteEntity c WHERE c.estado = :estado")
    List<ClienteEntity> findByEstado(@Param("estado") String estado);

    // Buscar por fecha de ingreso
    @Query("SELECT c FROM ClienteEntity c WHERE c.fechaIngreso = :fechaIngreso")
    List<ClienteEntity> findByFechaIngreso(@Param("fechaIngreso") LocalDate fechaIngreso);
}

