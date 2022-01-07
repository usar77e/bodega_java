package com.bodega.backend.model;

import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Schema(description = "Listado de usuarios de sistema")
@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    @Schema(description = "Llave primaria de usuarios, auto-incrementable Identity")
    private Integer idUsuario;

    @NotNull
    @Schema(description = "Nombre de usuario de la aplicacion, maximo 100 caracteres, no acepta valores nulos")
    @Column(name = "nombre", length = 100)
    @Size(message = "nombre de usuario de la aplicacion")
    private String nombre;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario, String nombre) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
