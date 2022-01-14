package com.bodega.backend.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RolesPerfilesKey implements Serializable {

    @Column(name = "id_rol")
    Integer idRol;

    @Column(name = "id_perfil")
    Integer idPerfil;

    public RolesPerfilesKey() {
    }

    public RolesPerfilesKey(Integer idRol, Integer idPerfil) {
        this.idRol = idRol;
        this.idPerfil = idPerfil;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }
}
