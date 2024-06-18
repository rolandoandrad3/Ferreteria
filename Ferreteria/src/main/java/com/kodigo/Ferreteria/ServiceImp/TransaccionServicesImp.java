package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.TransaccionDao;
import com.kodigo.Ferreteria.Service.TransaccionService;
import com.kodigo.Ferreteria.entity.TransaccionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class TransaccionServicesImp implements TransaccionService {
    @Autowired
    private TransaccionDao transaccionDao;
    @Override
    public List<TransaccionEntity> listTransaccion() {
        return transaccionDao.findAll();
    }

    @Override
    public TransaccionEntity createTransaccion(TransaccionEntity transaccionEntity) {
        return transaccionDao.save(transaccionEntity);
    }

    @Override
    public TransaccionEntity updateTransaccion() {
        return null;
    }

    @Override
    public void deleteTransaccion(Integer id) {transaccionDao.deleteById(id);

    }
}
