package com.bodega.backend.controller;

import com.bodega.backend.model.Movimientos;
import com.bodega.backend.service.MovimientosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientosController {
    @Autowired
    private MovimientosService movimientosService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request / datos no enviados correctamente."),
            @ApiResponse(responseCode = "404", description = "Not Found / No encontrado"),
            @ApiResponse(responseCode = "405", description = "No se encontraron movimientos en la Base de Datos"),
            @ApiResponse(responseCode = "200", description = "peticion OK")
    })

    @Operation(summary = "Obtener todas los movimientos",
            description = "No necesita parametros de entrada",
            method = "GET")
    @GetMapping("")
    public ResponseEntity<List<Movimientos>> findAll(){
        return new ResponseEntity<>(movimientosService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un movimiento por ID",
            description = "Necesita una ID numerica existente",
            method = "GET")
    @GetMapping("/{id}")
    public Movimientos findById(@PathVariable("id") Integer id){
        return movimientosService.findById(id);
    }

    @Operation(summary = "Crear un nuevo Ingreso o egreso",
            description = "necesita la id tipo de operacion, id de usuario y la fecha de creacion",
            method = "POST")
    @PostMapping
    public @ResponseBody Movimientos save(@RequestBody Movimientos movimientos){
        return movimientosService.save(movimientos);
    }
}
