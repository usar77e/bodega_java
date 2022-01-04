package com.bodega.backend.service.impl;

import com.bodega.backend.exception.ModelNoFoundException;
import com.bodega.backend.model.Movimientos;
import com.bodega.backend.repository.MovimientosRepository;
import com.bodega.backend.service.MovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientosServiceImpl implements MovimientosService {
    @Autowired
    private MovimientosRepository movimientosRepository;

    @Autowired
    public MovimientosServiceImpl(MovimientosRepository movimientosRepository) {
        this.movimientosRepository = movimientosRepository;
    }

    @Override
    public List<Movimientos> findAll() {
        return movimientosRepository.findAll();
    }

    @Override
    public Movimientos findById(Integer id) {
        Optional<Movimientos> movimientos = movimientosRepository.findById(id);
        if(movimientos.isPresent()){
            return movimientos.get();
        } else {
            throw new ModelNoFoundException("Movimiento no encontrado");
        }
    }

    @Override
    public Movimientos save(Movimientos movimientos) {
        return movimientosRepository.save(movimientos);
    }

    @Override
    public Movimientos update(Movimientos movimientos) {
        return save(movimientos);
    }

    @Override
    public boolean delete(Integer id) {
        movimientosRepository.deleteById(id);
        return true;
    }
}
