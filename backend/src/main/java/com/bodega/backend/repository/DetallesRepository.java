package com.bodega.backend.repository;

import com.bodega.backend.model.Detalles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesRepository extends JpaRepository<Detalles, Integer> {
}
