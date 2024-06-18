package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.TiposPagoDao;
import com.kodigo.Ferreteria.Service.TiposPagoService;
import com.kodigo.Ferreteria.entity.TiposPagoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return null;
    }

    @Override
    public void deleteTiposPago(Integer id) {tiposPagoDao.deleteById(id);

    }
}
