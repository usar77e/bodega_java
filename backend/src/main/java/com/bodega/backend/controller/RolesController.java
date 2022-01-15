package com.bodega.backend.controller;

import com.bodega.backend.model.Roles;
import com.bodega.backend.service.RolesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request / datos no enviados correctamente."),
            @ApiResponse(responseCode = "404", description = "Not Found / No encontrado"),
            @ApiResponse(responseCode = "405", description = "No se encontraron roles en la Base de Datos"),
            @ApiResponse(responseCode = "200", description = "peticion OK")
    })

    @Operation(summary = "Obtener todas los roles de la base de datos",
            description = "No necesita parametros de entrada",
            method = "GET")
    @GetMapping("")
    public ResponseEntity<List<Roles>> findAll(){
        return new ResponseEntity<>(rolesService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un rol por ID",
            description = "Necesita una ID numerica existente",
            method = "GET")
    @GetMapping("/{id}")
    public Roles findById(@PathVariable("id") Integer id) {
        return rolesService.findById(id);
    }

    @Operation(summary = "Obtener un perfil por su nombre",
            description = "Necesita el nombre del perfil",
            method = "GET")
    @GetMapping("/name/{name}")
    public List<Roles> findByName(@PathVariable("name") String name){
        return rolesService.findByName(name);
    }

    @GetMapping("/condition/{estado}")
    public List<Roles> findByCondition(@PathVariable("estado") Boolean estado){
        return rolesService.findByCondition(estado);
    }

    @Operation(summary = "Crear un nuevo rol",
            description = "Necesita una cadena de texto con el nombre",
            method = "POST")
    @PostMapping
    public @ResponseBody Roles save(@RequestBody Roles roles){
        return rolesService.save(roles);
    }
}
