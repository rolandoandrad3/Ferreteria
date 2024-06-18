package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.ProductosDao;
import com.kodigo.Ferreteria.Service.ProductosService;
import com.kodigo.Ferreteria.entity.ProductosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ProductosServiceImp implements ProductosService {
    @Autowired
    private ProductosDao productosDao;
    @Override
    public List<ProductosEntity> listProductos() {
        return productosDao.findAll();
    }

    @Override
    public ProductosEntity createProductos(ProductosEntity productosEntity) {
        return productosDao.save(productosEntity);
    }

    @Override
    public ProductosEntity updateProductos(ProductosEntity productosEntity) {
        return null;
    }

    @Override
    public void deleteProductos(Integer id) {productosDao.deleteById(id);
    }
}
