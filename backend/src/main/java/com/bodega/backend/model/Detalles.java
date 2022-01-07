package com.bodega.backend.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Schema(description = "Detalles de operacion de la tabla movimientos")
@Entity
@Table(name = "detalles")
public class Detalles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Llave primaria de detalles de movimientos, auto-incrementable Identity")
    @Column(name = "id_detalle")
    private Integer IdDetalle;

    @NotNull
    @Positive
    @Schema(description = "campo registra cantidad de productos que ingresan o salen")
    @Column(name = "cantidad")
    private int cantidad;

    @ManyToOne
    @Schema(description = "llave foranea a movimientos")
    @JoinColumn(name = "id_movimiento", nullable = false, foreignKey = @ForeignKey(name = "FK_detalle_movimiento"))
    private Movimientos movimientos;

    @ManyToOne
    @Schema(description = "llave foranea a productos")
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
