package com.bodega.backend.model;

import javax.persistence.*;

@Entity
public class MarcaProducto {

    @EmbeddedId
    MarcaProductoKey id;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "id_producto")
    Productos productos;

    @ManyToOne
    @MapsId("idMarca")
    @JoinColumn(name = "id_marca")
    Marcas marcas;

    public MarcaProductoKey getId() {
        return id;
    }

    public void setId(MarcaProductoKey id) {
        this.id = id;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Marcas getMarcas() {
        return marcas;
    }

    public void setMarcas(Marcas marcas) {
        this.marcas = marcas;
    }
}
