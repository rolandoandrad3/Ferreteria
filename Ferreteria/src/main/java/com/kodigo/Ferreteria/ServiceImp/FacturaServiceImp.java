package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.FacturaDao;
import com.kodigo.Ferreteria.Service.FacturaService;
import com.kodigo.Ferreteria.entity.FacturaEntity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

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
    @Transactional
    public FacturaEntity updateFactura(FacturaEntity facturaEntity) {
        Optional<FacturaEntity> optionalFactura = facturaDao.findById(Math.toIntExact(facturaEntity.getId()));
        if (optionalFactura.isPresent()) {
            FacturaEntity existingFactura = optionalFactura.get();
            existingFactura.setFechaFactura(facturaEntity.getFechaFactura());
            existingFactura.setTotal(facturaEntity.getTotal());
            existingFactura.setCliente(facturaEntity.getCliente());
            existingFactura.setEmpleado(facturaEntity.getEmpleado());
            existingFactura.setProducto(facturaEntity.getProducto());
            existingFactura.setCategoria(facturaEntity.getCategoria());
            existingFactura.setPago(facturaEntity.getPago());
            existingFactura.setTiposPago(facturaEntity.getTiposPago());
            return facturaDao.save(existingFactura);
        } else {
            throw new EntityNotFoundException("La factura con id " + facturaEntity.getId() + " no existe.");
        }
    }

    @Override
    public void deleteFactura(Integer id) { facturaDao.deleteById(id);

    }
}
