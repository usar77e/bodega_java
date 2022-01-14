package com.bodega.backend.dto;

import com.bodega.backend.model.Marcas;
import com.bodega.backend.model.TipoProductos;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

public class TipoProductoDTO extends RepresentationModel implements Serializable {
    private Integer idProducto;
    private String nombre;
    private Integer cantidad;
    private TipoProductos tipoProductos;
    private Marcas marcas;

    public TipoProductoDTO() {
    }

    public TipoProductoDTO(Integer idProducto, String nombre, Integer cantidad, TipoProductos tipoProductos , Marcas marcas) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipoProductos = tipoProductos;
        this.marcas = marcas;
    }

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

    public Marcas getMarcas() {
        return marcas;
    }

    public void setMarcas(Marcas marcas) {
        this.marcas = marcas;
    }
}
