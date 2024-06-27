package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.DetalleFacturaEntity;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFacturaDao extends JpaRepository<DetalleFacturaEntity, Integer> {
}
