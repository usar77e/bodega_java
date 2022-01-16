package com.bodega.backend.dto;

import com.bodega.backend.model.Perfiles;
import com.bodega.backend.model.Roles;
import com.bodega.backend.model.RolesPerfiles;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

public class UsuarioRolesDTO extends RepresentationModel implements Serializable {
    private Integer idUsuario;
    private String nombre;
    private String correo;
    private Perfiles perfiles;
    private RolesPerfiles rolesPerfiles;
    private Roles roles;

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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Perfiles getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(Perfiles perfiles) {
        this.perfiles = perfiles;
    }

    public RolesPerfiles getRolesPerfiles() {
        return rolesPerfiles;
    }

    public void setRolesPerfiles(RolesPerfiles rolesPerfiles) {
        this.rolesPerfiles = rolesPerfiles;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
