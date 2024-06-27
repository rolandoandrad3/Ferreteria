package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.EmpleadoEntity;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmpleadoDao extends JpaRepository<EmpleadoEntity, Integer> {
    // Buscar por apellido
    @Query("SELECT e FROM EmpleadoEntity e WHERE e.apellido = :apellido")
    List<EmpleadoEntity> findByApellido(@Param("apellido") String apellido);

    // Buscar por DUI
    @Query("SELECT e FROM EmpleadoEntity e WHERE e.dui = :dui")
    List<EmpleadoEntity> findByDui(@Param("dui") String dui);

    // Buscar por fecha de contratación
    @Query("SELECT e FROM EmpleadoEntity e WHERE e.fechaContratacion = :fechaContratacion")
    List<EmpleadoEntity> findByFechaContratacion(@Param("fechaContratacion") LocalDate fechaContratacion);

    // Buscar por cargo
    @Query("SELECT e FROM EmpleadoEntity e WHERE e.cargo = :cargo")
    List<EmpleadoEntity> findByCargo(@Param("cargo") String cargo);

}
