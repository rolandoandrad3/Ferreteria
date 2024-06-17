package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.CategoriaDao;
import com.kodigo.Ferreteria.Service.CategoriaService;
import com.kodigo.Ferreteria.entity.CategoriaEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoriaServiceImp implements CategoriaService {
    @Autowired
    private CategoriaDao categoriaDao;
    @Override
    public List<CategoriaEntity> listCategoria() {
        return categoriaDao.findAll();
    }

    @Override
    public CategoriaEntity creatCategoria(CategoriaEntity categoriaEntity) {
        return categoriaDao.save(categoriaEntity);
    }
    //Need to create logic for update
    @Override
    public CategoriaEntity updateCategoria(CategoriaEntity categoriaEntity) {
        return null;
    }

    @Override
    public void deleteCategoria(Integer id) { categoriaDao.deleteById(id);    }
}
