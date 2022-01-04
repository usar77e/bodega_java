package com.bodega.backend.controller;

import com.bodega.backend.model.Productos;
import com.bodega.backend.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @GetMapping("")
    public ResponseEntity<List<Productos>> findAll(){
        return new ResponseEntity<>(productosService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Productos findById(@PathVariable("id") Integer id){
        return productosService.findById(id);
    }

    @PostMapping
    public @ResponseBody Productos save(@RequestBody Productos productos){
        return productosService.save(productos);
    }
}
