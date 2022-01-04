package com.bodega.backend.service.impl;

import com.bodega.backend.exception.ModelNoFoundException;
import com.bodega.backend.model.Usuarios;
import com.bodega.backend.repository.UsuariosRepository;
import com.bodega.backend.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
