package com.bodega.backend.model;

import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Schema(description = "Listado de usuarios de sistema")
@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    @Schema(description = "Llave primaria de usuarios, auto-incrementable Identity")
    private Integer idUsuario;

    @NotNull
    @Schema(description = "Nombre de usuario de la aplicacion, maximo 100 caracteres, no acepta valores nulos")
    @Column(name = "nombre", length = 100)
    @Size(message = "nombre de usuario de la aplicacion")
    private String nombre;

    @NotNull
    @Email
    @Schema(description = "Email de usuario de la aplicacion, maximo 100 caracteres, no acepta valores nulos")
    @Column(name = "email", length = 50)
    @Size(message = "email de usuario de la aplicacion")
    private String correo;

    @NotNull
    @Schema(description = "password de usuario de la aplicacion, maximo 100 caracteres, no acepta valores nulos")
    @Column(name = "password", length = 50)
    @Size(message = "password de usuario de la aplicacion")
    private String password;

    @NotNull
    @Schema(description = "estado del usuario, no acepta valores nulos")
    @Column(name = "estado")
    @Size(message = "estado de usuario de la aplicacion")
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_perfil", nullable = false, foreignKey = @ForeignKey(name = "FK_usuario_perfiles"))
    private Perfiles perfiles;
/*
    @OneToMany(mappedBy = "usuarios", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private List<Movimientos> movimientos;
*/
    public Usuarios() {
    }

    public Usuarios(Integer idUsuario, String nombre, String correo, String password, Boolean estado, Perfiles perfiles, List<Movimientos> movimientos) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.estado = estado;
        this.perfiles = perfiles;
  //      this.movimientos = movimientos;
    }
/*
    public List<Movimientos> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimientos> movimientos) {
        this.movimientos = movimientos;
    }
*/
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Perfiles getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(Perfiles perfiles) {
        this.perfiles = perfiles;
    }
}
