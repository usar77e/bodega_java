package com.bodega.backend.service.impl;

import com.bodega.backend.exception.ModelNoFoundException;
import com.bodega.backend.model.Productos;
import com.bodega.backend.repository.ProductosRepository;
import com.bodega.backend.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosServiceImpl implements ProductosService {
    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    public ProductosServiceImpl(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    @Override
    public List<Productos> findAll() {
        return productosRepository.findAll();
    }

    @Override
    public Productos findById(Integer id) {
        Optional<Productos> producto = productosRepository.findById(id);
        if (producto.isPresent()){
            return producto.get();
        }else{
            throw new ModelNoFoundException("Producto no encontrado");
        }
    }

    @Override
    public Productos save(Productos productos) {
        return productosRepository.save(productos);
    }

    @Override
    public Productos update(Productos productos) {
        return save(productos);
    }

    @Override
    public boolean delete(Integer id) {
        productosRepository.deleteById(id);
        return true;
    }
}
