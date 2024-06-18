package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.ProveedorDao;
import com.kodigo.Ferreteria.Service.ProveedorService;
import com.kodigo.Ferreteria.entity.ProveedorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return null;
    }

    @Override
    public void deleteProveedor(Integer id) {proveedorDao.deleteById(id);

    }
}
