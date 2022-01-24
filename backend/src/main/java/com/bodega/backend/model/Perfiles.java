package com.bodega.backend.model;

import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Schema(description = "Listado de perfiles del sistema")
@Entity
@Table(name = "perfiles")
public class Perfiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    @Schema(description = "Llave primaria de perfiles, auto-incrementable Identity")
    private Integer idPerfil;

    @NotNull
    @Schema(description = "Nombre de los perfiles de la aplicacion, maximo 100 caracteres, no acepta valores nulos")
    @Column(name = "nombre", length = 100)
    @Size(message = "nombre de usuario de la aplicacion")
    private String nombre;

    @NotNull
    @Schema(description = "Estado de perfiles de la aplicacion, maximo 100 caracteres, no acepta valores nulos")
    @Column(name = "estado", length = 100)
    @Size(message = "estado de usuario de la aplicacion")
    private Boolean estado;

/*    @OneToMany(mappedBy = "perfiles", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private List<Usuarios> usuarios;

    @OneToMany(mappedBy = "perfiles", cascade = { CascadeType.ALL }, orphanRemoval = true)
    private List<RolesPerfiles> rolesPerfiles;
*/
    public Perfiles() {
    }

    public Perfiles(Integer idPerfil, String nombre, Boolean estado, List<Usuarios> usuarios) {
        this.idPerfil = idPerfil;
        this.nombre = nombre;
        this.estado = estado;
  //      this.usuarios = usuarios;
    }

/*    public List<RolesPerfiles> getRolesPerfiles() {
        return rolesPerfiles;
    }

    public void setRolesPerfiles(List<RolesPerfiles> rolesPerfiles) {
        this.rolesPerfiles = rolesPerfiles;
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }*/

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
