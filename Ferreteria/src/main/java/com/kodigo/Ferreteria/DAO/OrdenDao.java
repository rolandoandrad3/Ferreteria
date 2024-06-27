package com.kodigo.Ferreteria.DAO;

import com.kodigo.Ferreteria.entity.OrdenEntity;
import org.hibernate.mapping.Selectable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenDao extends JpaRepository<OrdenEntity, Long> {

    //Buscar por fecha
    List<OrdenEntity> findByFecha(String fecha);

    // Buscar por empleado
    @Query("Select e from OrdenEntity e where e.empleado.id =:empleadoId")
    List<OrdenEntity> findByEmpleadoId(@Param("empleadoId") Long empleadoId);
    // Buscar por categoría de producto
    @Query("SELECT o FROM OrdenEntity o WHERE o.producto.categoria.id = :categoriaId")
    List<OrdenEntity> findByCategoriaProducto(@Param("categoriaId") Long categoriaId);
}
