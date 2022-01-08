package com.bodega.backend.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MarcaProductoKey implements Serializable {

    @Column(name = "id_producto")
    Integer idProducto;

    @Column(name = "id_marca")
    Integer idMarca;

    public MarcaProductoKey() {
    }

    public MarcaProductoKey(Integer idProducto, Integer idMarca) {
        this.idProducto = idProducto;
        this.idMarca = idMarca;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }
}
