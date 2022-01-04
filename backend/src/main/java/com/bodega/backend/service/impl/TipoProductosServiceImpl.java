package com.bodega.backend.service.impl;

import com.bodega.backend.exception.ModelNoFoundException;
import com.bodega.backend.model.TipoProductos;
import com.bodega.backend.repository.TipoProductosRepository;
import com.bodega.backend.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoProductosServiceImpl implements TipoProductoService {

    @Autowired
    private TipoProductosRepository tipoProductosRepository;

    @Autowired
    public TipoProductosServiceImpl(TipoProductosRepository tipoProductosRepository) {
        this.tipoProductosRepository = tipoProductosRepository;
    }

    @Override
    public List<TipoProductos> findAll() {
        return tipoProductosRepository.findAll();
    }

    @Override
    public TipoProductos findById(Integer id) {
        Optional<TipoProductos> tipoProductos = tipoProductosRepository.findById(id);
        if(tipoProductos.isPresent()){
            return tipoProductos.get();
        }else{
            throw  new ModelNoFoundException("Tipo de producto no encontrado.");
        }

    }

    @Override
    public TipoProductos save(TipoProductos tipoProductos) {
        return tipoProductosRepository.save(tipoProductos);
    }

    @Override
    public TipoProductos update(TipoProductos tipoProductos) {
        return save(tipoProductos);
    }

    @Override
    public boolean delete(Integer id) {
        tipoProductosRepository.deleteById(id);
        return true;
    }
}
