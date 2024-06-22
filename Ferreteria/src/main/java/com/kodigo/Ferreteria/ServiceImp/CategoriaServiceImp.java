package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.CategoriaDao;
import com.kodigo.Ferreteria.Service.CategoriaService;
import com.kodigo.Ferreteria.entity.CategoriaEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


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
        // Verificar que la entidad existe
        Optional<CategoriaEntity> optionalCategoria = categoriaDao.findById(Math.toIntExact(categoriaEntity.getId()));
        if (optionalCategoria.isPresent()) {
            CategoriaEntity existingCategoria = optionalCategoria.get();
            existingCategoria.setNombreCategoria(categoriaEntity.getNombreCategoria());
            return categoriaDao.save(existingCategoria);
        } else {
            throw new EntityNotFoundException("La categoría con id " + categoriaEntity.getId() + " no existe.");
        }
    }

    @Override
    public void deleteCategoria(Integer id) { categoriaDao.deleteById(id);    }
}
