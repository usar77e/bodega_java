package com.bodega.backend.controller;

import com.bodega.backend.model.Tipos;
import com.bodega.backend.service.TiposService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request / datos no enviados correctamente."),
            @ApiResponse(responseCode = "404", description = "Not Found / No encontrado"),
            @ApiResponse(responseCode = "405", description = "No se encontraron tipos de movimientos en la Base de Datos"),
            @ApiResponse(responseCode = "200", description = "peticion OK")
    })

    @Operation(summary = "Obtener todas tipos de movimientos los productos",
            description = "No necesita parametros de entrada",
            method = "GET")
    @GetMapping("")
    public ResponseEntity<List<Tipos>> findAll(){
        return new ResponseEntity<>(tiposService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un tipos de producto por ID",
            description = "Necesita una ID numerica existente",
            method = "GET")
    @GetMapping("/{id}")
    public Tipos findById(@PathVariable("id") Integer id){
        return tiposService.findById(id);
    }

    @Operation(summary = "Crear un nuevo tipo de producto",
            description = "necesaria cadena de texto ",
            method = "POST")
    @PostMapping
    public @ResponseBody Tipos save(@RequestBody Tipos tipos){
        return tiposService.save(tipos);
    }
}
