package com.bodega.backend.service;

import com.bodega.backend.dto.UsuarioRolesDTO;
import com.bodega.backend.model.Usuarios;

import java.util.List;

public interface UsuariosService extends ICRUD<Usuarios>{

    List<Usuarios> findByName(String nombre);

    List<Usuarios> findByEmail(String correo);

    List<Usuarios> findByConditon(Boolean estado);

    List<UsuarioRolesDTO> findAllUsuarios();
}
