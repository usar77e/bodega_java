package com.bodega.backend.model;

import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.util.List;

@Schema(description = "Listado de marcas de productos")
@Entity
@Table(name = "marcas")
public class Marcas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Llave primaria de marca, auto-incrementable Identity")
    @Column(name = "id_marca")
    private Integer idMarca;

    @NotNull
    @Schema(description = "Nombre de la marca del producto, maximo 70 caracteres, no acepta valores nulos")
    @Column(unique = true, name = "nombre", length = 70)
    private String nombre;
/*
    @OneToMany(mappedBy = "marcas", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private List<Productos> productos;
*/
    public Marcas() {
    }

    public Marcas(Integer idMarca, String nombre, List<Productos> productos) {
        this.idMarca = idMarca;
        this.nombre = nombre;
       // this.productos = productos;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

/*    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }*/
}
