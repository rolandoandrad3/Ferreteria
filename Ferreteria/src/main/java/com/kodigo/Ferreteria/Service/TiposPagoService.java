package com.kodigo.Ferreteria.Service;

import com.kodigo.Ferreteria.entity.TiposPagoEntity;

import java.util.List;

public interface TiposPagoService {
    public List<TiposPagoEntity> listTiposPago();
    public TiposPagoEntity createTiposPago(TiposPagoEntity tiposPagoEntity);
    public TiposPagoEntity updateTiposPago(TiposPagoEntity tiposPagoEntity);
    public void deleteTiposPago(Integer id);
}
