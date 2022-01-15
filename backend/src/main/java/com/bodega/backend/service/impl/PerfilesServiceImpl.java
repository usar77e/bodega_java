package com.bodega.backend.service.impl;

import com.bodega.backend.exception.ModelNoFoundException;
import com.bodega.backend.model.Perfiles;
import com.bodega.backend.repository.PerfilesRepository;
import com.bodega.backend.service.PerfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilesServiceImpl implements PerfilesService {

    @Autowired
    private PerfilesRepository perfilesRepository;

    public PerfilesServiceImpl(PerfilesRepository perfilesRepository) {
        this.perfilesRepository = perfilesRepository;
    }

    @Override
    public List<Perfiles> findAll() {
        return perfilesRepository.findAll();
    }

    @Override
    public Perfiles findById(Integer id) {
        Optional<Perfiles> perfiles = perfilesRepository.findById(id);
        if (perfiles.isPresent()){
            return perfiles.get();
        }else{
            throw new ModelNoFoundException("Perfil no encontrado");
        }
    }

    @Override
    public Perfiles save(Perfiles perfiles) {
        return perfilesRepository.save(perfiles);
    }

    @Override
    public Perfiles update(Perfiles perfiles) {
        return save(perfiles);
    }

    @Override
    public boolean delete(Integer id) {
        perfilesRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Perfiles> findByName(String nombre) {
        return perfilesRepository.findAllByNombre(nombre);
    }

    @Override
    public List<Perfiles> findByCondition(Boolean estado) {
        return perfilesRepository.findAllByEstado(estado);
    }
}
