package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.PagoDao;
import com.kodigo.Ferreteria.Service.PagoService;
import com.kodigo.Ferreteria.entity.PagoEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PagoServiceImp implements PagoService {
    @Autowired
    private PagoDao pagoDao;
    @Override
    public List<PagoEntity> listPago() {
        return pagoDao.findAll();
    }

    @Override
    public PagoEntity createPago(PagoEntity pagoEntity) {
        return pagoDao.save(pagoEntity);
    }

    @Override
    public PagoEntity updatePago(PagoEntity pagoEntity) {
        Optional<PagoEntity> optionalPago = pagoDao.findById(Math.toIntExact(pagoEntity.getId()));
        if (optionalPago.isPresent()) {
            PagoEntity existingPago = optionalPago.get();
            existingPago.setMonto(pagoEntity.getMonto());
            existingPago.setFechaPago(pagoEntity.getFechaPago());
            existingPago.setFactura(pagoEntity.getFactura());
            existingPago.setTiposPago(pagoEntity.getTiposPago());
            return pagoDao.save(existingPago);
        } else {
            throw new EntityNotFoundException("El pago con id " + pagoEntity.getId() + " no existe.");
        }
    }

    @Override
    public void deletePago(Integer id) { pagoDao.deleteById(id);

    }
}
