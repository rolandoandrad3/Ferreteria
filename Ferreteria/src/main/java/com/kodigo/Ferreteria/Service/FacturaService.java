package com.kodigo.Ferreteria.Service;

import com.kodigo.Ferreteria.entity.FacturaEntity;

import java.util.List;

public interface FacturaService {
    public List<FacturaEntity> listFactura();
    public FacturaEntity createFactura(FacturaEntity facturaEntity);
    public FacturaEntity updateFactura(FacturaEntity facturaEntity);
    public void deleteFactura(Integer id);
}
