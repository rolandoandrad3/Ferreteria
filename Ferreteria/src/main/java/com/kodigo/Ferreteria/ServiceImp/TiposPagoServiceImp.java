package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.TiposPagoDao;
import com.kodigo.Ferreteria.Service.TiposPagoService;
import com.kodigo.Ferreteria.entity.TiposPagoEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TiposPagoServiceImp implements TiposPagoService {
    @Autowired
    private TiposPagoDao tiposPagoDao;
    @Override
    public List<TiposPagoEntity> listTiposPago() {
        return tiposPagoDao.findAll();
    }

    @Override
    public TiposPagoEntity createTiposPago(TiposPagoEntity tiposPagoEntity) {
        return tiposPagoDao.save(tiposPagoEntity);
    }

    @Override
    public TiposPagoEntity updateTiposPago(TiposPagoEntity tiposPagoEntity) {
        Optional<TiposPagoEntity> optionalTiposPago = tiposPagoDao.findById(Math.toIntExact(tiposPagoEntity.getId()));
        if (optionalTiposPago.isPresent()) {
            TiposPagoEntity existingTiposPago = optionalTiposPago.get();
            existingTiposPago.setTipoPago(tiposPagoEntity.getTipoPago());
            return tiposPagoDao.save(existingTiposPago);
        } else {
            throw new EntityNotFoundException("El tipo de pago con id " + tiposPagoEntity.getId() + " no existe.");
        }
    }

    @Override
    public void deleteTiposPago(Integer id) {tiposPagoDao.deleteById(id);

    }
}
