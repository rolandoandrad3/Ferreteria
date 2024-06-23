package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.DetalleFacturaDao;
import com.kodigo.Ferreteria.Service.DetalleFacturaService;
import com.kodigo.Ferreteria.entity.DetalleFacturaEntity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DetalleFacturaImp implements DetalleFacturaService {
    @Autowired
    private DetalleFacturaDao detalleFacturaDao;
    @Override
    public List<DetalleFacturaEntity> listDetalleFactura() {
        return detalleFacturaDao.findAll();
    }

    @Override
    public DetalleFacturaEntity createDetalleFactura(DetalleFacturaEntity detalleFacturaEntity) {
        return detalleFacturaDao.save(detalleFacturaEntity);
    }
    @Override
    @Transactional
    public DetalleFacturaEntity updateDetalleFactura(DetalleFacturaEntity detalleFacturaEntity) {
        Optional<DetalleFacturaEntity> optionalDetalle = detalleFacturaDao.findById(Math.toIntExact(detalleFacturaEntity.getId()));
        if (optionalDetalle.isPresent()) {
            DetalleFacturaEntity existingDetalle = optionalDetalle.get();
            existingDetalle.setCantidad(detalleFacturaEntity.getCantidad());
            existingDetalle.setPrecioUnitario(detalleFacturaEntity.getPrecioUnitario());
            existingDetalle.setSubtotal(detalleFacturaEntity.getSubtotal());
            existingDetalle.setProducto(detalleFacturaEntity.getProducto());
            existingDetalle.setFactura(detalleFacturaEntity.getFactura());
            return detalleFacturaDao.save(existingDetalle);
        } else {
            throw new EntityNotFoundException("El detalle de factura con id " + detalleFacturaEntity.getId() + " no existe.");
        }
    }

    @Override
    public void deleteDetalleFactura(Integer id) { detalleFacturaDao.deleteById(id);

    }
}
