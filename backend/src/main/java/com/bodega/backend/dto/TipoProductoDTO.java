package com.bodega.backend.dto;

import com.bodega.backend.model.TipoProductos;

import java.io.Serializable;

public class TipoProductoDTO implements Serializable {
    private Integer idProducto;
    private String nombre;
    private Integer cantidad;
    private TipoProductos tipoProductos;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public TipoProductos getTipoProductos() {
        return tipoProductos;
    }

    public void setTipoProductos(TipoProductos tipoProductos) {
        this.tipoProductos = tipoProductos;
    }
}
