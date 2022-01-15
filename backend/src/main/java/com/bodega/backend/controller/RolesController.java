package com.bodega.backend.controller;

import com.bodega.backend.model.Roles;
import com.bodega.backend.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    public ResponseEntity<List<Roles>> findAll(){
        return new ResponseEntity<>(rolesService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Roles findById(@PathVariable("id") Integer id) {
        return rolesService.findById(id);
    }

    @PostMapping
    public @ResponseBody Roles save(@RequestBody Roles roles){
        return rolesService.save(roles);
    }
}
