package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.TransaccionDao;
import com.kodigo.Ferreteria.Service.TransaccionService;
import com.kodigo.Ferreteria.entity.TransaccionEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public TransaccionEntity updateTransaccion(TransaccionEntity transaccionEntity) {
        Optional<TransaccionEntity> optionalTransaccion = transaccionDao.findById(Math.toIntExact(transaccionEntity.getId()));
        if (optionalTransaccion.isPresent()) {
            TransaccionEntity existingTransaccion = optionalTransaccion.get();
            existingTransaccion.setFecha(transaccionEntity.getFecha());
            existingTransaccion.setMonto(transaccionEntity.getMonto());
            existingTransaccion.setCliente(transaccionEntity.getCliente());
            existingTransaccion.setFactura(transaccionEntity.getFactura());
            existingTransaccion.setPago(transaccionEntity.getPago());
            existingTransaccion.setProducto(transaccionEntity.getProducto());
            existingTransaccion.setCategoria(transaccionEntity.getCategoria());
            existingTransaccion.setProveedor(transaccionEntity.getProveedor());
            existingTransaccion.setEmpleado(transaccionEntity.getEmpleado());
            existingTransaccion.setPersona(transaccionEntity.getPersona());
            existingTransaccion.setTiposPagoEntity(transaccionEntity.getTiposPagoEntity());
            existingTransaccion.setTiposTransaccionEntity(transaccionEntity.getTiposTransaccionEntity());
            return transaccionDao.save(existingTransaccion);
        } else {
            throw new EntityNotFoundException("La transacción con id " + transaccionEntity.getId() + " no existe.");
        }
    }

    @Override
    public void deleteTransaccion(Long id) {
        transaccionDao.deleteById(Math.toIntExact(id));
    }


}
