package com.bodega.backend.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "marcas")
public class Marcas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Integer idMarca;

    @NotNull
    @Column(unique = true, name = "nombre", length = 70)
    private String nombre;

    public Marcas() {
    }

    public Marcas(Integer idMarca, String nombre) {
        this.idMarca = idMarca;
        this.nombre = nombre;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
