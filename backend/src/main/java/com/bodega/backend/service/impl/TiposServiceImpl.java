package com.bodega.backend.service.impl;

import com.bodega.backend.exception.ModelNoFoundException;
import com.bodega.backend.model.Tipos;
import com.bodega.backend.repository.TiposRepository;
import com.bodega.backend.service.TiposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiposServiceImpl implements TiposService {
    @Autowired
    private TiposRepository tiposRepository;

    @Autowired
    public TiposServiceImpl(TiposRepository tiposRepository) {
        this.tiposRepository = tiposRepository;
    }

    @Override
    public List<Tipos> findAll() {
        return tiposRepository.findAll();
    }

    @Override
    public Tipos findById(Integer id) {
        Optional<Tipos> tipos = tiposRepository.findById(id);
        if(tipos.isPresent()){
            return tipos.get();
        } else {
            throw new ModelNoFoundException("Tipo no encontrado");
        }
    }

    @Override
    public Tipos save(Tipos tipos) {
        return tiposRepository.save(tipos);
    }

    @Override
    public Tipos update(Tipos tipos) {
        return save(tipos);
    }

    @Override
    public boolean delete(Integer id) {
        tiposRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Tipos> findByName(String nombre) {
        return tiposRepository.findAllByNombre(nombre);
    }
}
