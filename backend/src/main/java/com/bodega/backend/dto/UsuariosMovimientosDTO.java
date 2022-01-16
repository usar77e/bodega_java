package com.bodega.backend.dto;

import com.bodega.backend.model.Movimientos;
import com.bodega.backend.model.Perfiles;
import com.bodega.backend.model.Tipos;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

public class UsuariosMovimientosDTO extends RepresentationModel implements Serializable {
    private Integer idUsuario;
    private String nombreUSuario;
    private String correo;
    private Perfiles perfiles;
    private Movimientos movimientos;
    private Tipos tipos;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUSuario() {
        return nombreUSuario;
    }

    public void setNombreUSuario(String nombreUSuario) {
        this.nombreUSuario = nombreUSuario;
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

    public Movimientos getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Movimientos movimientos) {
        this.movimientos = movimientos;
    }

    public Tipos getTipos() {
        return tipos;
    }

    public void setTipos(Tipos tipos) {
        this.tipos = tipos;
    }
}
