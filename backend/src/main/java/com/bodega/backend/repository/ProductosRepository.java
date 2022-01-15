package com.bodega.backend.repository;

import com.bodega.backend.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {
    //buscar por nombre
    List<Productos> findAllByNombre(String nombre);

    //buscar por modelo
    List<Productos> findAllByModelo(String modelo);

    //buscar por cantidad
    List<Productos> findAllByCantidad(Integer cantidad);

}
