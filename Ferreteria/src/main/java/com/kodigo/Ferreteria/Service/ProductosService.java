package com.kodigo.Ferreteria.Service;

import com.kodigo.Ferreteria.entity.ProductosEntity;

import java.util.List;

public interface ProductosService {
    public List<ProductosEntity> listProductos();
    public ProductosEntity createProductos(ProductosEntity productosEntity);
    public ProductosEntity updateProductos(ProductosEntity productosEntity);
    public void deleteProductos(Long id);
    List<ProductosEntity> findByNombre(String nombre);

    List<ProductosEntity> findByCategoriaId(Long categoriaId);

    List<ProductosEntity> findByPrecioGreaterThan(Double precio);


}
