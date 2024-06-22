package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.TiposTransaccionDao;
import com.kodigo.Ferreteria.Service.TiposTransaccionService;
import com.kodigo.Ferreteria.entity.TiposTransaccionEntity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TiposTransaccionServicesImp implements TiposTransaccionService {
    @Autowired
    private TiposTransaccionDao tiposTransaccionDao;
    @Override
    public List<TiposTransaccionEntity> listTiposTransaccion() {
        return tiposTransaccionDao.findAll();
    }

    @Override
    public TiposTransaccionEntity createTiposTransaccion(TiposTransaccionEntity tiposTransaccionEntity) {
        return tiposTransaccionDao.save(tiposTransaccionEntity);
    }

    @Override
    @Transactional
    public TiposTransaccionEntity updateTiposTransaccion(TiposTransaccionEntity tiposTransaccionEntity) {
        Optional<TiposTransaccionEntity> optionalTiposTransaccion = tiposTransaccionDao.findById(Math.toIntExact(tiposTransaccionEntity.getId()));
        if (optionalTiposTransaccion.isPresent()) {
            TiposTransaccionEntity existingTiposTransaccion = optionalTiposTransaccion.get();
            existingTiposTransaccion.setTipoTransaccion(tiposTransaccionEntity.getTipoTransaccion());
            return tiposTransaccionDao.save(existingTiposTransaccion);
        } else {
            throw new EntityNotFoundException("El tipo de transacción con id " + tiposTransaccionEntity.getId() + " no existe.");
        }
    }

    @Override
    public void deleteTiposTransaccion(Integer id) { tiposTransaccionDao.deleteById(id);

    }
}
