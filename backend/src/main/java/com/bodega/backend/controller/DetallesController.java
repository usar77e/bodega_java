package com.bodega.backend.controller;

import com.bodega.backend.model.Detalles;
import com.bodega.backend.service.DetallesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalles")
public class DetallesController {
    @Autowired
    private DetallesService detallesService;

    @GetMapping("")
    public ResponseEntity<List<Detalles>> findAll(){
        return new ResponseEntity<>(detallesService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Detalles findById(@PathVariable("id") Integer id){
        return detallesService.findById(id);
    }

    @PostMapping
    public @ResponseBody Detalles save(@RequestBody Detalles detalles){
        return detallesService.save(detalles);
    }
}
