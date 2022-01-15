package com.bodega.backend.repository;

import com.bodega.backend.model.Tipos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TiposRepository extends JpaRepository<Tipos, Integer> {
    //buscar por nombre
    List<Tipos> findAllByNombre(String nombre);
}
