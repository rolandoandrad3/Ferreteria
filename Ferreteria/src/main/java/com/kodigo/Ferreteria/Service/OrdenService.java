package com.kodigo.Ferreteria.Service;

import com.kodigo.Ferreteria.entity.OrdenEntity;

import java.util.List;

public interface OrdenService {
    public List<OrdenEntity> findAll();

    public OrdenEntity findById(Integer id);

    public OrdenEntity nuevaOrden(OrdenEntity orden);

    public OrdenEntity updateOrden(OrdenEntity orden);

    public void deleteById(Integer id);
}
