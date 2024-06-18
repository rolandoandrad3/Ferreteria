package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.ClientesDao;
import com.kodigo.Ferreteria.Service.ClienteService;
import com.kodigo.Ferreteria.entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return null;
    }

    @Override
    public void deleteCliente(Integer id) {clientesDao.deleteById(id);
    }
}
