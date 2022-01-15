package com.bodega.backend.repository;

import com.bodega.backend.model.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovimientosRepository extends JpaRepository<Movimientos, Integer> {
    //buscar por fecha
    List<Movimientos> findAllByFechaIngreso(Date fecha);
}
