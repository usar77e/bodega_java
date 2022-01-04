package com.bodega.backend.controller;

import com.bodega.backend.model.Tipos;
import com.bodega.backend.service.TiposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TiposController {
    @Autowired
    private TiposService tiposService;

    @GetMapping("")
    public ResponseEntity<List<Tipos>> findAll(){
        return new ResponseEntity<>(tiposService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Tipos findById(@PathVariable("id") Integer id){
        return tiposService.findById(id);
    }

    @PostMapping
    public @ResponseBody Tipos save(@RequestBody Tipos tipos){
        return tiposService.save(tipos);
    }
}
