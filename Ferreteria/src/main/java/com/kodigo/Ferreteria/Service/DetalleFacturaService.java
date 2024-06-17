package com.kodigo.Ferreteria.Service;

import com.kodigo.Ferreteria.entity.DetalleFacturaEntity;

import java.util.List;

public interface DetalleFacturaService {
    public List<DetalleFacturaEntity> listDetalleFactura();
    public DetalleFacturaEntity createDetalleFactura(DetalleFacturaEntity detalleFacturaEntity);
    public DetalleFacturaEntity updateDetalleFactura(DetalleFacturaEntity detalleFacturaEntity);
    public void deleteDetalleFactura(Integer id);
}
