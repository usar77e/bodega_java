package com.bodega.backend.dto;

import com.bodega.backend.model.MarcaProducto;
import com.bodega.backend.model.Marcas;
import com.bodega.backend.model.TipoProductos;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

public class TipoProductoDTO extends RepresentationModel implements Serializable {
    private Integer idProducto;
    private String nombre;
    private Integer cantidad;
    private TipoProductos tipoProductos;
    private MarcaProducto marcaProducto;
    private Marcas marcas;

    public TipoProductoDTO() {
    }

    public TipoProductoDTO(Integer idProducto, String nombre, Integer cantidad, TipoProductos tipoProductos, MarcaProducto marcaProducto, Marcas marcas) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipoProductos = tipoProductos;
        this.marcaProducto = marcaProducto;
        this.marcas = marcas;
    }

    public MarcaProducto getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(MarcaProducto marcaProducto) {
        this.marcaProducto = marcaProducto;
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
