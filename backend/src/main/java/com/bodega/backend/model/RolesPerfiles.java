package com.bodega.backend.model;

import javax.persistence.*;

@Entity
public class RolesPerfiles {

    @EmbeddedId
    RolesPerfilesKey id;

    @ManyToOne
    @MapsId("idPerfil")
    @JoinColumn(name = "id_perfil")
    Perfiles perfiles;

    @ManyToOne
    @MapsId("idRol")
    @JoinColumn(name = "id_rol")
    Roles roles;

    public RolesPerfiles() {
    }

    public RolesPerfiles(RolesPerfilesKey id, Perfiles perfiles, Roles roles) {
        this.id = id;
        this.perfiles = perfiles;
        this.roles = roles;
    }

    public RolesPerfilesKey getId() {
        return id;
    }

    public void setId(RolesPerfilesKey id) {
        this.id = id;
    }

    public Perfiles getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(Perfiles perfiles) {
        this.perfiles = perfiles;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
