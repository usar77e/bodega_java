package com.bodega.backend.service;

import com.bodega.backend.model.TipoProductos;

import java.util.List;

public interface TipoProductoService extends ICRUD<TipoProductos>{
    List<TipoProductos> findByName(String nombre);
}
