package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.OrdenDao;
import com.kodigo.Ferreteria.Service.OrdenService;
import com.kodigo.Ferreteria.entity.OrdenEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdenServiceImpl implements OrdenService {
    @Autowired
    private OrdenDao ordenDao;
    @Override
    public List<OrdenEntity> findAll() {
        return ordenDao.findAll();
    }

    @Override
    public OrdenEntity findById(Integer id) {
        return ordenDao.findById(id.longValue()).orElse(null);
    }

    @Override
    public OrdenEntity nuevaOrden(OrdenEntity orden) {
        if (ordenDao.existsById(orden.getId())) {
            return ordenDao.save(orden);
        } else {
            // Manejar la situación cuando la orden no existe.
            // Podrías lanzar una excepción personalizada o retornar null.
            throw new RuntimeException("Orden no encontrada con ID: " + orden.getId());
        }
    }

    @Override
    public OrdenEntity updateOrden(OrdenEntity orden) {
        return ordenDao.save(orden);
    }

    @Override
    public void deleteById(Integer id) { ordenDao.deleteById(Long.valueOf(id));

    }

    // Implementación de los nuevos métodos de búsqueda

    @Override
    public List<OrdenEntity> findByFecha(String fecha) {
        return ordenDao.findByFecha(fecha);
    }

    @Override
    public List<OrdenEntity> findByEmpleado(Long empleadoId) {
        return ordenDao.findByEmpleadoId(empleadoId);
    }

    @Override
    public List<OrdenEntity> findByCategoriaProducto(Long categoriaId) {
        return ordenDao.findByCategoriaProducto(categoriaId);
    }
}
