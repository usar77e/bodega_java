package com.bodega.backend.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.List;

@Entity
@Table(name = "productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @NotNull
    @Column(unique = true, name = "nombre", length = 70)
    private String nombre;

    @NotNull
    @Column(unique = true, name = "modelo", length = 70)
    private String modelo;

    @NotNull
    @Positive
    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_tproducto", nullable = false, foreignKey = @ForeignKey(name = "FK_productos_tipoproductos"))
    private TipoProductos tipoProductos;

    @ManyToMany
    @JoinTable(name = "marca_producto",
    joinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "id_producto"),
    inverseJoinColumns = @JoinColumn(name = "id_marca", referencedColumnName = "id_marca"))
    private List<Marcas> marcas;

    public Productos() {
    }

    public Productos(Integer idProducto, String nombre, String modelo, Integer cantidad, TipoProductos tipoProductos, List<Marcas> marcas) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.modelo = modelo;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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

    public List<Marcas> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marcas> marcas) {
        this.marcas = marcas;
    }
}
