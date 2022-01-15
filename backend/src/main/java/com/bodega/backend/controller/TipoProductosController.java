package com.bodega.backend.controller;

import com.bodega.backend.model.TipoProductos;
import com.bodega.backend.service.TipoProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo_productos")
public class TipoProductosController {
    @Autowired
    private TipoProductoService tipoProductoService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request / datos no enviados correctamente."),
            @ApiResponse(responseCode = "404", description = "Not Found / No encontrado"),
            @ApiResponse(responseCode = "405", description = "No se encontraron Tipos de productos en la Base de Datos"),
            @ApiResponse(responseCode = "200", description = "peticion OK")
    })

    @Operation(summary = "Obtener todas los Tipos de productos",
            description = "No necesita parametros de entrada",
            method = "GET")
    @GetMapping("")
    public ResponseEntity<List<TipoProductos>> findAll(){
        return new ResponseEntity<>(tipoProductoService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un Tipo de producto por ID",
            description = "Necesita una ID numerica existente",
            method = "GET")
    @GetMapping("/{id}")
    public TipoProductos findById(@PathVariable("id") Integer id){
        return tipoProductoService.findById(id);
    }

    @Operation(summary = "Obtener un tipo de producto por nombre",
            description = "Necesita el nombre del tipo de producto",
            method = "GET")
    @GetMapping("/name/{name}")
    public List<TipoProductos> findByName(@PathVariable("name") String name){
        return tipoProductoService.findByName(name);
    }

    @Operation(summary = "Crear un nuevo Tipo de Producto",
            description = "necesita cadena de texto",
            method = "POST")
    @PostMapping
    public @ResponseBody TipoProductos save(@RequestBody TipoProductos tipoProductos){
        return tipoProductoService.save(tipoProductos);
    }
}
