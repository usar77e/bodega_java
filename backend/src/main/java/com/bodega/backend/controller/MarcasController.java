package com.bodega.backend.controller;

import com.bodega.backend.model.Marcas;
import com.bodega.backend.service.MarcasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request / datos no enviados correctamente."),
            @ApiResponse(responseCode = "404", description = "Not Found / No encontrado"),
            @ApiResponse(responseCode = "405", description = "No se encontraron marcas en la Base de Datos"),
            @ApiResponse(responseCode = "200", description = "peticion OK")
    })

    @Operation(summary = "Obtener todas las marcas de los productos",
            description = "No necesita parametros de entrada",
            method = "GET")
    @GetMapping("")
    public ResponseEntity<List<Marcas>> findAll(){
        return new ResponseEntity<>(marcasService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener una marcas por ID",
            description = "Necesita una ID numerica existente",
            method = "GET")
    @GetMapping("/{id}")
    public Marcas findById(@PathVariable("id") Integer id){
        return marcasService.findById(id);
    }

    @Operation(summary = "Crear una nueva marca",
            description = "Necesita una cadena de texto con el nombre",
            method = "POST")
    @PostMapping
    public @ResponseBody Marcas save(@RequestBody Marcas marcas){
        return marcasService.save(marcas);
    }
}
