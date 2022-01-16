package com.bodega.backend.dto;

import com.bodega.backend.model.Detalles;
import com.bodega.backend.model.Productos;
import com.bodega.backend.model.Tipos;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

public class MovimientosProductosDTO extends RepresentationModel implements Serializable {
    private Integer idMovimiento;
    private Detalles detalles;
    private Tipos tipos;
    private Productos productos;

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Detalles getDetalles() {
        return detalles;
    }

    public void setDetalles(Detalles detalles) {
        this.detalles = detalles;
    }

    public Tipos getTipos() {
        return tipos;
    }

    public void setTipos(Tipos tipos) {
        this.tipos = tipos;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }
}
