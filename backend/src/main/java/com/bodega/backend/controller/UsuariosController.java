package com.bodega.backend.controller;

import com.bodega.backend.model.Usuarios;
import com.bodega.backend.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("")
    public ResponseEntity<List<Usuarios>> findAll(){
        return new ResponseEntity<>(usuariosService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Usuarios findById(@PathVariable("id") Integer id){
        return usuariosService.findById(id);
    }

    @PostMapping
    public @ResponseBody Usuarios save(@RequestBody Usuarios usuarios){
        return usuariosService.save(usuarios);
    }
}
