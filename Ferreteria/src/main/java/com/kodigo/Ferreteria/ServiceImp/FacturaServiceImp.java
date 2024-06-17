package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.FacturaDao;
import com.kodigo.Ferreteria.Service.FacturaService;
import com.kodigo.Ferreteria.entity.FacturaEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FacturaServiceImp implements FacturaService {
    @Autowired
    private FacturaDao facturaDao;
    @Override
    public List<FacturaEntity> listFactura() {
        return facturaDao.findAll();
    }

    @Override
    public FacturaEntity createFactura(FacturaEntity facturaEntity) {
        return facturaDao.save(facturaEntity);
    }

    @Override
    public FacturaEntity updateFactura(FacturaEntity facturaEntity) {
        return null;
    }

    @Override
    public void deleteFactura(Integer id) { facturaDao.deleteById(id);

    }
}
