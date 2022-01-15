package com.bodega.backend.repository;

import com.bodega.backend.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    //buscar por nombres
    List<Usuarios> findAllByNombre(String nombre);

    //buscar por correos
    List<Usuarios> findAllByCorreo(String correo);


    //buscar por estados
    List<Usuarios> findAllByEstado(Boolean estado);
}
