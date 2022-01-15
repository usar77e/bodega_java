package com.bodega.backend.controller;

import com.bodega.backend.model.Perfiles;
import com.bodega.backend.service.PerfilesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfiles")
public class PerfilesController {
    @Autowired
    private PerfilesService perfilesService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request / datos no enviados correctamente."),
            @ApiResponse(responseCode = "404", description = "Not Found / No encontrado"),
            @ApiResponse(responseCode = "405", description = "No se encontraron perfiles en la Base de Datos"),
            @ApiResponse(responseCode = "200", description = "peticion OK")
    })

    @Operation(summary = "Obtener todas los perfiles de la base de datos",
            description = "No necesita parametros de entrada",
            method = "GET")
    @GetMapping("")
    public ResponseEntity<List<Perfiles>> findAll(){
        return new ResponseEntity<>(perfilesService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un perfil por ID",
            description = "Necesita una ID numerica existente",
            method = "GET")
    @GetMapping("/{id}")
    public Perfiles findById(@PathVariable("id") Integer id){ return perfilesService.findById(id);}

    @Operation(summary = "Obtener un perfil por su nombre",
            description = "Necesita el nombre del perfil",
            method = "GET")
    @GetMapping("/name/{name}")
    public List<Perfiles> findByName(@PathVariable("name") String name){
        return perfilesService.findByName(name);
    }

    @Operation(summary = "Obtener un listado de perfiles por su estado",
            description = "Necesita estado a buscar",
            method = "GET")
    @GetMapping("condition/{estado}")
    public List<Perfiles> findByCondition(@PathVariable("estado") Boolean estado){
        return perfilesService.findByCondition(estado);
    }

    @Operation(summary = "Crear un nuevo perfil",
            description = "Necesita una cadena de texto con el nombre",
            method = "POST")
    @PostMapping
    public @ResponseBody Perfiles save(@RequestBody Perfiles perfiles){ return perfilesService.save(perfiles);}
}
