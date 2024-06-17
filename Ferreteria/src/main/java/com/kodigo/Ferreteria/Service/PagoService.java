package com.kodigo.Ferreteria.Service;

import com.kodigo.Ferreteria.entity.PagoEntity;

import java.util.List;

public interface PagoService {
    public List<PagoEntity> listPago();
    public PagoEntity createPago(PagoEntity pagoEntity);
    public PagoEntity updatePago(PagoEntity pagoEntity);
    public void deletePago(Integer id);
}
