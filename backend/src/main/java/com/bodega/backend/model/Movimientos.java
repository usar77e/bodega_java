package com.bodega.backend.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;
import java.util.List;

@Schema(description = "Listado operaciones de entrada y salida de productos a la bodega")
@Entity
@Table(name = "movimientos")
public class Movimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Llave primaria de movimientos, auto-incrementable Identity")
    @Column(name = "id_movimiento")
    private Integer idMovimiento;

    @Temporal(TemporalType.TIMESTAMP)
    @Schema(description = "fecha de ingreso de la operacion, fecha actual o futura, no acepta nulos ni se puede modificar")
    @PastOrPresent
    @Column(name = "fecha_ingreso", updatable = false, nullable = false)
    private Date fechaIngreso;

    @ManyToOne
    @Schema(description = "llave foranea a usuarios")
    @JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "FK_movimiento_usuario"))
    private Usuarios usuarios;

    @ManyToOne
    @Schema(description = "llave foranea a tipos")
    @JoinColumn(name = "id_tipo", nullable = false, foreignKey = @ForeignKey(name = "FK_movimiento_tipo"))
    private Tipos tipos;

    @OneToMany(mappedBy = "movimientos", cascade = { CascadeType.ALL })
    private List<Detalles> detalles;

    public Movimientos() {
    }

    public Movimientos(Integer idMovimiento, Date fechaIngreso, Usuarios usuarios, Tipos tipos, List<Detalles> detalles) {
        this.idMovimiento = idMovimiento;
        this.fechaIngreso = fechaIngreso;
        this.usuarios = usuarios;
        this.tipos = tipos;
        this.detalles = detalles;
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

    public List<Detalles> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalles> detalles) {
        this.detalles = detalles;
    }


}
