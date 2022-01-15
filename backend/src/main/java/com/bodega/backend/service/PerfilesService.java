package com.bodega.backend.service;

import com.bodega.backend.model.Perfiles;

import java.util.List;

public interface PerfilesService extends ICRUD<Perfiles>{
    List<Perfiles> findByName(String nombre);

    List<Perfiles> findByCondition(Boolean estado);
}
