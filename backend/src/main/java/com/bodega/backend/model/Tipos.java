package com.bodega.backend.model;

import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;

@Schema(description = "Tipo de operacion de la tabla movimiento")
@Entity
@Table(name = "tipos")
public class Tipos {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Schema(description = "Llave primaria de tipo de movimiento, auto-incrementable Identity")
    @Column(name = "id_tipo")
    private Integer idTipo;

    @NotNull
    @Schema(description = "Nombre de tipo de movimiento, caracteres maximos 20, no acepta valores nulos ni repetidos")
    @Column(unique = true, name = "nombre", length = 20)
    private String nombre;

    public Tipos() {
    }

    public Tipos(Integer idTipo, String nombre) {
        this.idTipo = idTipo;
        this.nombre = nombre;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
