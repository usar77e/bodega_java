package com.bodega.backend.repository;

import com.bodega.backend.model.TipoProductos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductosRepository extends JpaRepository<TipoProductos, Integer> {
}
