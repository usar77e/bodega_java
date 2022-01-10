package com.bodega.backend.service;

import com.bodega.backend.dto.MovimientoDetallesDTO;
import com.bodega.backend.model.Movimientos;

import java.util.List;

public interface MovimientosService extends ICRUD<Movimientos>{
    List<MovimientoDetallesDTO> findAllMovDTO();
}
