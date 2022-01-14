package com.bodega.backend.model;

import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

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

    public Usuarios() {
    }

}
