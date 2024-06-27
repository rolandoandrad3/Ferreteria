package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.ProductosDao;
import com.kodigo.Ferreteria.Service.ProductosService;
import com.kodigo.Ferreteria.entity.ProductosEntity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    @Transactional
    public ProductosEntity updateProductos(ProductosEntity productoEntity) {
        Optional<ProductosEntity> optionalProducto = productosDao.findById(productoEntity.getId());
        if (optionalProducto.isPresent()) {
            ProductosEntity existingProducto = optionalProducto.get();
            existingProducto.setNombreProducto(productoEntity.getNombreProducto());
            existingProducto.setDescripcion(productoEntity.getDescripcion());
            existingProducto.setCantidad(productoEntity.getCantidad());
            existingProducto.setPrecio(productoEntity.getPrecio());
            existingProducto.setFecha(productoEntity.getFecha());
            existingProducto.setCategoria(productoEntity.getCategoria());
            return productosDao.save(existingProducto);
        } else {
            throw new EntityNotFoundException("El producto con id " + productoEntity.getId() + " no existe.");
        }
    }

    @Override
    public void deleteProductos(Long id) {productosDao.deleteById(id);
    }
    @Override
    public List<ProductosEntity> findByNombre(String nombre) {
        return productosDao.findByNombre(nombre);
    }

    @Override
    public List<ProductosEntity> findByCategoriaId(Long categoriaId) {
        return productosDao.findByCategoriaId(categoriaId);
    }

    @Override
    public List<ProductosEntity> findByPrecioGreaterThan(Double precio) {
        return productosDao.findByPrecioGreaterThan(precio);
    }

}
