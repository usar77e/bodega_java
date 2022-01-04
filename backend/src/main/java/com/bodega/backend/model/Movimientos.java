package com.bodega.backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movimientos")
public class Movimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Integer idMovimiento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_ingreso", updatable = false, nullable = false)
    private Date fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "FK_movimiento_usuario"))
    private Usuarios usuarios;

    @ManyToOne
    @JoinColumn(name = "id_tipo", nullable = false, foreignKey = @ForeignKey(name = "FK_movimiento_tipo"))
    private Tipos tipos;

    public Movimientos() {
    }

    public Movimientos(Integer idMovimiento, Date fechaIngreso, Usuarios usuarios, Tipos tipos) {
        this.idMovimiento = idMovimiento;
        this.fechaIngreso = fechaIngreso;
        this.usuarios = usuarios;
        this.tipos = tipos;
    }

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Tipos getTipos() {
        return tipos;
    }

    public void setTipos(Tipos tipos) {
        this.tipos = tipos;
    }
}
