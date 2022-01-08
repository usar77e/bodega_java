package com.bodega.backend.dto;



import com.bodega.backend.model.Marcas;
import com.bodega.backend.model.Productos;

import java.io.Serializable;
import java.util.List;

public class MarcaProductoDto implements Serializable {
    private Productos productos;
    private List<Marcas> lstMarcas;

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public List<Marcas> getLstMarcas() {
        return lstMarcas;
    }

    public void setLstMarcas(List<Marcas> lstMarcas) {
        this.lstMarcas = lstMarcas;
    }
}
