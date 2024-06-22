package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.ClientesDao;
import com.kodigo.Ferreteria.Service.ClienteService;
import com.kodigo.Ferreteria.entity.ClienteEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ClienteServiceImp implements ClienteService {
    @Autowired
    private ClientesDao clientesDao;
    @Override
    public List<ClienteEntity> listAllClientes() {
        return clientesDao.findAll();
    }

    @Override
    public ClienteEntity createCliente(ClienteEntity clienteEntity) {
        return clientesDao.save(clienteEntity);
    }

    //update missing
    @Override
    public ClienteEntity updateCliente(ClienteEntity clienteEntity) {
        Optional<ClienteEntity> optionalCliente = clientesDao.findById(Math.toIntExact(clienteEntity.getId()));
        if (optionalCliente.isPresent()) {
            ClienteEntity existingCliente = optionalCliente.get();
            existingCliente.setFechaIngreso(clienteEntity.getFechaIngreso());
            existingCliente.setEstado(clienteEntity.getEstado());
            return clientesDao.save(existingCliente);
        } else {
            throw new EntityNotFoundException("El cliente con id " + clienteEntity.getId() + " no existe.");
        }
    }

    @Override
    public void deleteCliente(Integer id) {clientesDao.deleteById(id);
    }
}
