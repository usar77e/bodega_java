package com.bodega.backend.repository;

import com.bodega.backend.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
    //buscar por nombre
    List<Roles> findAllByNombre(String nombre);

    //buscar por estado
    List<Roles> findAllByEstado(Boolean estado);
}
