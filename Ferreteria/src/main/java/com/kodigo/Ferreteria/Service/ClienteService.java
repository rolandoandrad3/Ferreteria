package com.kodigo.Ferreteria.Service;

import com.kodigo.Ferreteria.entity.ClienteEntity;

import java.util.List;

public interface ClienteService {
    public List<ClienteEntity> listAllClientes();
    public ClienteEntity createCliente(ClienteEntity clienteEntity);
    public ClienteEntity updateCliente(ClienteEntity clienteEntity);
    public void deleteCliente(Integer id);
}
