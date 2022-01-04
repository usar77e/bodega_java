package com.bodega.backend.controller;

import com.bodega.backend.model.Marcas;
import com.bodega.backend.service.MarcasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcasController {

    @Autowired
    private MarcasService marcasService;

    @GetMapping("")
    public ResponseEntity<List<Marcas>> findAll(){
        return new ResponseEntity<>(marcasService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Marcas findById(@PathVariable("id") Integer id){
        return marcasService.findById(id);
    }

    @PostMapping
    public @ResponseBody Marcas save(@RequestBody Marcas marcas){
        return marcasService.save(marcas);
    }
}
