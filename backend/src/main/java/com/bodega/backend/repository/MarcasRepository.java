package com.bodega.backend.repository;

import com.bodega.backend.model.Marcas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcasRepository extends JpaRepository<Marcas, Integer> {
    //buscar por nombre
    List<Marcas> findAllByNombre(String nombre);
}
