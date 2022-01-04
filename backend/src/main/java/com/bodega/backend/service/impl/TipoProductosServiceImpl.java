package com.bodega.backend.service.impl;

import com.bodega.backend.model.TipoProductos;
import com.bodega.backend.repository.TipoProductosRepository;
import com.bodega.backend.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProductosServiceImpl implements TipoProductoService {

    @Autowired
    private TipoProductosRepository tipoProductosRepository;

    public TipoProductosServiceImpl(TipoProductosRepository tipoProductosRepository) {
        this.tipoProductosRepository = tipoProductosRepository;
    }

    @Override
    public List<TipoProductos> findAll() {
        return tipoProductosRepository.findAll();
    }

    @Override
    public TipoProductos findById(Integer id) {
        return null;
    }

    @Override
    public TipoProductos save(TipoProductos tipoProductos) {
        return null;
    }

    @Override
    public TipoProductos update(TipoProductos tipoProductos) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
