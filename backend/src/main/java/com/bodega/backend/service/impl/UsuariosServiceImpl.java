package com.bodega.backend.service.impl;

import com.bodega.backend.dto.UsuarioRolesDTO;
import com.bodega.backend.exception.ModelNoFoundException;
import com.bodega.backend.model.Usuarios;
import com.bodega.backend.repository.UsuariosRepository;
import com.bodega.backend.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuariosService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    public UsuariosServiceImpl(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public List<Usuarios> findAll() {
        return usuariosRepository.findAll();
    }

    @Override
    public Usuarios findById(Integer id) {
        Optional<Usuarios> usuarios = usuariosRepository.findById(id);
        if(usuarios.isPresent()){
            return usuarios.get();
        }else{
            throw new ModelNoFoundException("Usuario no encontrado");
        }
    }

    @Override
    public Usuarios save(Usuarios usuarios) {
        return usuariosRepository.save(usuarios);
    }

    @Override
    public Usuarios update(Usuarios usuarios) {
        return save(usuarios);
    }

    @Override
    public boolean delete(Integer id) {
        usuariosRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Usuarios> findByName(String nombre) {
        return usuariosRepository.findAllByNombre(nombre);
    }

    @Override
    public List<Usuarios> findByEmail(String correo) {
        return usuariosRepository.findAllByCorreo(correo);
    }

    @Override
    public List<Usuarios> findByConditon(Boolean estado) {
        return usuariosRepository.findAllByEstado(estado);
    }

    @Override
    public List<UsuarioRolesDTO> findAllUsuarios() {
        List<UsuarioRolesDTO> udtos = new ArrayList<>();
        List<Usuarios> usuarios = usuariosRepository.findAll();
        usuarios.forEach(usuario -> {
            UsuarioRolesDTO usuarioRolesDTO = new UsuarioRolesDTO();
            usuarioRolesDTO.setIdUsuario(usuario.getIdUsuario());
            usuarioRolesDTO.setNombrePerfil(usuario.getPerfiles().getNombre());
            usuarioRolesDTO.setNombreRoles(usuario.getPerfiles().getRolesPerfiles().get(
                    usuario.getPerfiles().getIdPerfil()
            ).getRoles().getNombre());
            udtos.add(usuarioRolesDTO);
        });
        return null;
    }
}
