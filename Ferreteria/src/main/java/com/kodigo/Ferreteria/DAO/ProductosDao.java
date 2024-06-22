package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosDao extends JpaRepository<ProductosEntity, Long> {
}
