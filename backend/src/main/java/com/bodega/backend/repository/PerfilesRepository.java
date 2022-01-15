package com.bodega.backend.repository;

import com.bodega.backend.model.Perfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfilesRepository extends JpaRepository<Perfiles, Integer> {
    //buscar por nombre
    List<Perfiles> findAllByNombre(String nombre);

    //buscar por estado
    List<Perfiles> findAllByEstado(Boolean estado);
}
