package com.bodega.backend.repository;

import com.bodega.backend.model.Detalles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallesRepository extends JpaRepository<Detalles, Integer> {
    //buscar por cantidad
    List<Detalles> findAllByCantidad(Integer cantidad);
}
