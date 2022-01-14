package com.bodega.backend.model;

import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Schema(description = "Listado de los roles del sistema")
@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    @Schema(description = "Llave primaria de los roles, auto-incrementable Identity")
    private Integer idRol;

    @NotNull
    @Schema(description = "Nombre de los roles de la aplicacion, maximo 100 caracteres, no acepta valores nulos")
    @Column(name = "nombre", length = 100)
    @Size(message = "nombre de usuario de la aplicacion")
    private String nombre;

    @NotNull
    @Schema(description = "Estado de los roles de la aplicacion, maximo 100 caracteres, no acepta valores nulos")
    @Column(name = "estado", length = 100)
    @Size(message = "estado de usuario de la roles")
    private Boolean estado;

    public Roles() {
    }

    public Roles(Integer idRol, String nombre, Boolean estado) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
