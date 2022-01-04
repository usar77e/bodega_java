package com.bodega.backend.controller;

import com.bodega.backend.model.TipoProductos;
import com.bodega.backend.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo_productos")
public class TipoProductosController {
    @Autowired
    private TipoProductoService tipoProductoService;

    @GetMapping("")
    public ResponseEntity<List<TipoProductos>> findAll(){
        return new ResponseEntity<>(tipoProductoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TipoProductos findById(@PathVariable("id") Integer id){
        return tipoProductoService.findById(id);
    }

    @PostMapping
    public @ResponseBody TipoProductos save(@RequestBody TipoProductos tipoProductos){
        return tipoProductoService.save(tipoProductos);
    }
}
