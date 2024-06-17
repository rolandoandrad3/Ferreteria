package com.kodigo.Ferreteria.Service;

import com.kodigo.Ferreteria.entity.CategoriaEntity;

import java.util.List;

public interface CategoriaService {
    public List<CategoriaEntity> listCategoria();
    public CategoriaEntity creatCategoria(CategoriaEntity categoriaEntity);
    public CategoriaEntity updateCategoria(CategoriaEntity categoriaEntity);
    public void deleteCategoria(Integer id);
}
