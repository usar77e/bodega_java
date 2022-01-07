package com.bodega.backend.controller;

import com.bodega.backend.model.Detalles;
import com.bodega.backend.service.DetallesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request / datos no enviados correctamente."),
            @ApiResponse(responseCode = "404", description = "Not Found / No encontrado"),
            @ApiResponse(responseCode = "405", description = "No se encontraron detalles en la Base de Datos"),
            @ApiResponse(responseCode = "200", description = "peticion OK")
    })

    @Operation(summary = "Obtener todas los detalles de los movimientos",
            description = "No necesita parametros de entrada",
            method = "GET")
    @GetMapping("")
    public ResponseEntity<List<Detalles>> findAll(){
        return new ResponseEntity<>(detallesService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener una detalle por ID",
            description = "Necesita una ID numerica existente",
            method = "GET")
    @GetMapping("/{id}")
    public Detalles findById(@PathVariable("id") Integer id){
        return detallesService.findById(id);
    }

    @Operation(summary = "Crear un nuevo detalle de movimiento",
            description = "Es necesario un id de movimiento de producto y una cantidad superior a cero",
            method = "POST")
    @PostMapping
    public @ResponseBody Detalles save(@RequestBody Detalles detalles){
        return detallesService.save(detalles);
    }
}
