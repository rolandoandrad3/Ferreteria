package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.EmpleadoEntity;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoDao extends JpaRepository<EmpleadoEntity, Integer> {
}
