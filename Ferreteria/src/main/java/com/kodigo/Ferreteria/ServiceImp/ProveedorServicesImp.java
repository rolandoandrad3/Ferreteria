package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.ProveedorDao;
import com.kodigo.Ferreteria.Service.ProveedorService;
import com.kodigo.Ferreteria.entity.ProveedorEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProveedorServicesImp implements ProveedorService {
    @Autowired
    private ProveedorDao proveedorDao;
    @Override
    public List<ProveedorEntity> listProveedor() {
        return proveedorDao.findAll();
    }

    @Override
    public ProveedorEntity createProveedor(ProveedorEntity proveedorEntity) {
        return proveedorDao.save(proveedorEntity);
    }

    @Override
    public ProveedorEntity updateProveedor(ProveedorEntity proveedorEntity) {
        Optional<ProveedorEntity> optionalProveedor = proveedorDao.findById(Math.toIntExact(proveedorEntity.getId()));
        if (optionalProveedor.isPresent()) {
            ProveedorEntity existingProveedor = optionalProveedor.get();
            existingProveedor.setEstado(proveedorEntity.getEstado());
            existingProveedor.setFechaIngreso(proveedorEntity.getFechaIngreso());
            existingProveedor.setFechaCreacion(proveedorEntity.getFechaCreacion());
            existingProveedor.setPersona(proveedorEntity.getPersona());
            return proveedorDao.save(existingProveedor);
        } else {
            throw new EntityNotFoundException("El proveedor con id " + proveedorEntity.getId() + " no existe.");
        }
    }

    @Override
    public void deleteProveedor(Integer id) {proveedorDao.deleteById(id);

    }
}
