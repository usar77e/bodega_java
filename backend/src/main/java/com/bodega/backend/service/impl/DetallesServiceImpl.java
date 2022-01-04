package com.bodega.backend.service.impl;

import com.bodega.backend.exception.ModelNoFoundException;
import com.bodega.backend.model.Detalles;
import com.bodega.backend.repository.DetallesRepository;
import com.bodega.backend.service.DetallesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallesServiceImpl implements DetallesService {
    @Autowired
    private DetallesRepository detallesRepository;

    @Autowired
    public DetallesServiceImpl(DetallesRepository detallesRepository) {
        this.detallesRepository = detallesRepository;
    }

    @Override
    public List<Detalles> findAll() {
        return detallesRepository.findAll();
    }

    @Override
    public Detalles findById(Integer id) {
        Optional<Detalles> detalles = detallesRepository.findById(id);
        if(detalles.isPresent()){
            return detalles.get();
        }else{
            throw new ModelNoFoundException("Detalle de movimiento no encontrado");
        }
    }

    @Override
    public Detalles save(Detalles detalles) {
        return detallesRepository.save(detalles);
    }

    @Override
    public Detalles update(Detalles detalles) {
        return save(detalles);
    }

    @Override
    public boolean delete(Integer id) {
        detallesRepository.deleteById(id);
        return true;
    }
}
