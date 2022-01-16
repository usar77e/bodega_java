package com.bodega.backend.dto;

import com.bodega.backend.model.Marcas;
import com.bodega.backend.model.TipoProductos;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

public class ProductosDTO extends RepresentationModel implements Serializable {
    private Integer idProducto;
    private String nombreProducto;
    private Marcas marcas;
    private TipoProductos tipoProductos;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Marcas getMarcas() {
        return marcas;
    }

    public void setMarcas(Marcas marcas) {
        this.marcas = marcas;
    }

    public TipoProductos getTipoProductos() {
        return tipoProductos;
    }

    public void setTipoProductos(TipoProductos tipoProductos) {
        this.tipoProductos = tipoProductos;
    }
}
