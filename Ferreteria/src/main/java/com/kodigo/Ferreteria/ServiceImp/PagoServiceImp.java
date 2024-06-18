package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.PagoDao;
import com.kodigo.Ferreteria.Service.PagoService;
import com.kodigo.Ferreteria.entity.PagoEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class PagoServiceImp implements PagoService {
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
        return null;
    }

    @Override
    public void deletePago(Integer id) { pagoDao.deleteById(id);

    }
}
