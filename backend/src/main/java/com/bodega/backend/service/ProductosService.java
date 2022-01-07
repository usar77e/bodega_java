package com.bodega.backend.service;

import com.bodega.backend.dto.TipoProductoDTO;
import com.bodega.backend.model.Productos;

import java.util.List;

public interface ProductosService extends ICRUD<Productos>{

    List<TipoProductoDTO> findAllDto();
}
