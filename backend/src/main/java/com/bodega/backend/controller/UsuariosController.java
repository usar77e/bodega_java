package com.bodega.backend.controller;

import com.bodega.backend.dto.UsuarioRolesDTO;
import com.bodega.backend.model.Usuarios;
import com.bodega.backend.service.UsuariosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request / datos no enviados correctamente."),
            @ApiResponse(responseCode = "404", description = "Not Found / No encontrado"),
            @ApiResponse(responseCode = "405", description = "No se usuarios en la Base de Datos"),
            @ApiResponse(responseCode = "200", description = "peticion OK")
    })

    @Operation(summary = "Obtener todos los usuarios",
            description = "No necesita parametros de entrada",
            method = "GET")
    @GetMapping("")
    public ResponseEntity<List<Usuarios>> findAll(){
        return new ResponseEntity<>(usuariosService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un usuario por ID",
            description = "Necesita una ID numerica existente",
            method = "GET")
    @GetMapping("/{id}")
    public Usuarios findById(@PathVariable("id") Integer id){
        return usuariosService.findById(id);
    }

    @Operation(summary = "Obtener un usuario por nombre",
            description = "Necesita el nombre del usuario",
            method = "GET")
    @GetMapping("name/{name}")
    public List<Usuarios> findByName(@PathVariable("name") String name){
        return usuariosService.findByName(name);
    }

    @Operation(summary = "Obtener un usuario por su email",
            description = "Necesita el email del usuario",
            method = "GET")
    @GetMapping("/email/{correo}")
    public List<Usuarios> findByEmail(@PathVariable("correo") String correo){
        return usuariosService.findByEmail(correo);
    }

    @Operation(summary = "Obtener un listado de usuario por su estado",
            description = "Necesita estado a buscar",
            method = "GET")
    @GetMapping("/condition/{estado}")
    public List<Usuarios> findByCondition(@PathVariable("estado") Boolean estado){
        return usuariosService.findByConditon(estado);
    }

    @Operation(summary = "Crear un nuevo usuario",
            description = "necesaria una cadena de texto",
            method = "POST")
    @PostMapping
    public @ResponseBody Usuarios save(@RequestBody Usuarios usuarios){
        return usuariosService.save(usuarios);
    }

    @GetMapping("/dto-listado")
    public List<UsuarioRolesDTO> findAllUsuarios() {
        return usuariosService.findAllUsuarios();
    }
}
