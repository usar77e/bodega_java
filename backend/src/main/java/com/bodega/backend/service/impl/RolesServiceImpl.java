package com.bodega.backend.service.impl;

import com.bodega.backend.exception.ModelNoFoundException;
import com.bodega.backend.model.Roles;
import com.bodega.backend.repository.RolesRepository;
import com.bodega.backend.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public List<Roles> findAll() {
        return rolesRepository.findAll();
    }

    @Override
    public Roles findById(Integer id) {
        Optional<Roles> roles = rolesRepository.findById(id);
        if(roles.isPresent()){
            return roles.get();
        }else{
            throw new ModelNoFoundException("Rol no encontrado");
        }
    }

    @Override
    public Roles save(Roles roles) {
        return rolesRepository.save(roles);
    }

    @Override
    public Roles update(Roles roles) {
        return save(roles);
    }

    @Override
    public boolean delete(Integer id) {
        rolesRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Roles> findByName(String nombre) {
        return rolesRepository.findAllByNombre(nombre);
    }

    @Override
    public List<Roles> findByCondition(Boolean estado) {
        return rolesRepository.findAllByEstado(estado);
    }
}
