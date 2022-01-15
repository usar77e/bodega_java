package com.bodega.backend.service;

import com.bodega.backend.model.Marcas;

import java.util.List;

public interface MarcasService extends ICRUD<Marcas>{
    List<Marcas> findByName(String nombre);
}
