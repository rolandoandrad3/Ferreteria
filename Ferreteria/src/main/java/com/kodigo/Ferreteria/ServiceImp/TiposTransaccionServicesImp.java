package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.TiposTransaccionDao;
import com.kodigo.Ferreteria.Service.TiposTransaccionService;
import com.kodigo.Ferreteria.entity.TiposTransaccionEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public TiposTransaccionEntity updateTiposTransaccion(TiposTransaccionEntity tiposTransaccionEntity) {
        return null;
    }

    @Override
    public void deleteTiposTransaccion(Integer id) { tiposTransaccionDao.deleteById(id);

    }
}
