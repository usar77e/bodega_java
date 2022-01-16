package com.bodega.backend.dto;

import com.bodega.backend.model.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;

public class MovimientoDetallesDTO extends RepresentationModel implements Serializable {
    private Integer idMovimiento;
    private Date fechaIngreso;
    private Tipos tipos;
    private Usuarios usuarios;
    private Detalles detalles;
    private Productos productos;
    private TipoProductos tipoProductos;
    private Marcas marcas;

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Tipos getTipos() {
        return tipos;
    }

    public void setTipos(Tipos tipos) {
        this.tipos = tipos;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Detalles getDetalles() {
        return detalles;
    }

    public void setDetalles(Detalles detalles) {
        this.detalles = detalles;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public TipoProductos getTipoProductos() {
        return tipoProductos;
    }

    public void setTipoProductos(TipoProductos tipoProductos) {
        this.tipoProductos = tipoProductos;
    }

    public Marcas getMarcas() {
        return marcas;
    }

    public void setMarcas(Marcas marcas) {
        this.marcas = marcas;
    }
}
