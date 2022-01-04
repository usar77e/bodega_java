package com.bodega.backend.controller;

import com.bodega.backend.model.Movimientos;
import com.bodega.backend.service.MovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientosController {
    @Autowired
    private MovimientosService movimientosService;

    @GetMapping("")
    public ResponseEntity<List<Movimientos>> findAll(){
        return new ResponseEntity<>(movimientosService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Movimientos findById(@PathVariable("id") Integer id){
        return movimientosService.findById(id);
    }

    @PostMapping
    public @ResponseBody Movimientos save(@RequestBody Movimientos movimientos){
        return movimientosService.save(movimientos);
    }
}
