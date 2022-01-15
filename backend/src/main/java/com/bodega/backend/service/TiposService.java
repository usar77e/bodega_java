package com.bodega.backend.service;

import com.bodega.backend.model.Tipos;

import java.util.List;

public interface TiposService extends ICRUD<Tipos>{
    List<Tipos> findByName(String nombre);
}
