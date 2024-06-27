package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.ProductosEntity;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosDao extends JpaRepository<ProductosEntity, Long> {

    // Buscar por nombre del producto
    @Query("SELECT p FROM ProductosEntity p WHERE p.nombreProducto = :nombre")
    List<ProductosEntity> findByNombre(@Param("nombre") String nombre);

    // Buscar por categoría del producto
    @Query("SELECT p FROM ProductosEntity p WHERE p.categoria.id = :categoriaId")
    List<ProductosEntity> findByCategoriaId(@Param("categoriaId") Long categoriaId);

    // Buscar por precio mayor a un valor específico
    @Query("SELECT p FROM ProductosEntity p WHERE p.precio > :precio")
    List<ProductosEntity> findByPrecioGreaterThan(@Param("precio") Double precio);

}
