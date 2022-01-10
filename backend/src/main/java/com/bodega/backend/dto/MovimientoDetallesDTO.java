package com.bodega.backend.dto;

import com.bodega.backend.model.Detalles;
import com.bodega.backend.model.Tipos;
import com.bodega.backend.model.Usuarios;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

public class MovimientoDetallesDTO extends RepresentationModel implements Serializable {
    private Integer idMovimiento;
    private Usuarios usuarios;
    private Tipos tipos;
    private Detalles detalles;

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Tipos getTipos() {
        return tipos;
    }

    public void setTipos(Tipos tipos) {
        this.tipos = tipos;
    }

    public Detalles getDetalles() {
        return detalles;
    }

    public void setDetalles(Detalles detalles) {
        this.detalles = detalles;
    }
}
