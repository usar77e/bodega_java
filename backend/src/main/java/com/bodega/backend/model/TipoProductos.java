package com.bodega.backend.model;

import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;

@Schema(description = "Listado clasificacion de productos existentes")
@Entity
@Table(name = "tipo_productos")
public class TipoProductos {
    @Id
    @Column(name = "id_tproducto")
    @Schema(description = "Llave primaria de tipo de productos, auto-incrementable Identity")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTproducto;

    @NotNull
    @Schema(description = "Nombre de tipo de producto, maximo 70 caracteres, no acepta valores nulos")
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
