package com.bodega.backend.service;

import com.bodega.backend.model.Detalles;

import java.util.List;

public interface DetallesService extends ICRUD<Detalles>{
    List<Detalles> findByQuantity(Integer cantidad);
}
