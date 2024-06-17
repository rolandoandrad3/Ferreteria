package com.kodigo.Ferreteria.Service;

import com.kodigo.Ferreteria.entity.ProveedorEntity;

import java.util.List;

public interface ProveedorService {
    public List<ProveedorEntity> listProveedor();
    public ProveedorEntity createProveedor(ProveedorEntity proveedorEntity);
    public ProveedorEntity updateProveedor(ProveedorEntity proveedorEntity);
    public void deleteProveedor(Integer id);
}
