package com.bodega.backend.service.impl;

import com.bodega.backend.exception.ModelNoFoundException;
import com.bodega.backend.model.Marcas;
import com.bodega.backend.repository.MarcasRepository;
import com.bodega.backend.service.MarcasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcasServiceImpl implements MarcasService {
    @Autowired
    private MarcasRepository marcasRepository;

    @Autowired
    public MarcasServiceImpl(MarcasRepository marcasRepository) {
        this.marcasRepository = marcasRepository;
    }

    @Override
    public List<Marcas> findAll() {
        return marcasRepository.findAll();
    }

    @Override
    public Marcas findById(Integer id) {
        Optional<Marcas> marcas = marcasRepository.findById(id);
        if(marcas.isPresent()){
            return marcas.get();
        }else{
            throw  new ModelNoFoundException("Marca no encontrada.");
        }
    }

    @Override
    public Marcas save(Marcas marcas) {
        return marcasRepository.save(marcas);
    }

    @Override
    public Marcas update(Marcas marcas) {
        return save(marcas);
    }

    @Override
    public boolean delete(Integer id) {
        marcasRepository.deleteById(id);
        return true;
    }
}
