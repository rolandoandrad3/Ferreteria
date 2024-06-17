package com.kodigo.Ferreteria.Service;

import com.kodigo.Ferreteria.entity.TiposTransaccionEntity;

import java.util.List;

public interface TiposTransaccionService {
    public List<TiposTransaccionEntity> listTiposTransaccion();
    public TiposTransaccionEntity createTiposTransaccion(TiposTransaccionEntity tiposTransaccionEntity);
    public TiposTransaccionEntity updateTiposTransaccion(TiposTransaccionEntity tiposTransaccionEntity);
    public void deleteTiposTransaccion(Integer id);
}
