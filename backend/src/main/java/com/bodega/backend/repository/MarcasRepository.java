package com.bodega.backend.repository;

import com.bodega.backend.model.Marcas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcasRepository extends JpaRepository<Marcas, Integer> {
}
