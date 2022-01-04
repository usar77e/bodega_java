package com.bodega.backend.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "tipo_productos")
public class TipoProductos {
    @Id
    @Column(name = "id_tproducto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTproducto;

    @NotNull
    @Column(unique = true, name = "nombre", length = 70)
    private String nombre;

    public TipoProductos() {
    }

    public TipoProductos(Integer idTproducto, String nombre) {
        this.idTproducto = idTproducto;
        this.nombre = nombre;
    }

    public Integer getIdTproducto() {
        return idTproducto;
    }

    public void setIdTproducto(Integer idTproducto) {
        this.idTproducto = idTproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
