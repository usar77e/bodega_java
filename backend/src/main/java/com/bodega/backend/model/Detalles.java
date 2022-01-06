package com.bodega.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "detalles")
public class Detalles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer IdDetalle;

    @NotNull
    @Positive
    @Column(name = "cantidad")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "id_movimiento", nullable = false, foreignKey = @ForeignKey(name = "FK_detalle_movimiento"))
    private Movimientos movimientos;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false, foreignKey = @ForeignKey(name = "FK_detalle_producto"))
    private Productos productos;

    public Detalles() {
    }

    public Detalles(Integer idDetalle, int cantidad, Movimientos movimientos, Productos productos) {
        IdDetalle = idDetalle;
        this.cantidad = cantidad;
        this.movimientos = movimientos;
        this.productos = productos;
    }

    public Integer getIdDetalle() {
        return IdDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        IdDetalle = idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Movimientos getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Movimientos movimientos) {
        this.movimientos = movimientos;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }
}
