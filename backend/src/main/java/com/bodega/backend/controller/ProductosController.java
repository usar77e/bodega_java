package com.bodega.backend.controller;

import com.bodega.backend.dto.ProductosDTO;
import com.bodega.backend.dto.TipoProductoDTO;
import com.bodega.backend.model.Productos;
import com.bodega.backend.service.ProductosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.RepresentationModel.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request / datos no enviados correctamente."),
            @ApiResponse(responseCode = "404", description = "Not Found / No encontrado"),
            @ApiResponse(responseCode = "405", description = "No se encontraron movimientos en la Base de Datos"),
            @ApiResponse(responseCode = "200", description = "peticion OK")
    })

    @Operation(summary = "Obtener todas los productos",
            description = "No necesita parametros de entrada",
            method = "GET")
    @GetMapping("")
    public ResponseEntity<List<Productos>> findAll(){
        return new ResponseEntity<>(productosService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un producto por ID",
            description = "Necesita una ID numerica existente",
            method = "GET")
    @GetMapping("/{id}")
    public Productos findById(@PathVariable("id") Integer id){
        return productosService.findById(id);
    }

    @Operation(summary = "Crear un nuevo producto",
            description = "necesita la id tipo de operacion, id de usuario y la fecha de creacion",
            method = "POST")
    @PostMapping
    public @ResponseBody Productos save(@RequestBody Productos productos){
        return productosService.save(productos);
    }

    @GetMapping("/tipo-producto")
    public List<TipoProductoDTO> findAllDto(){
        List<TipoProductoDTO> dtos = new ArrayList<>();
        List<Productos> productos = productosService.findAll();
        productos.forEach(producto -> {
            TipoProductoDTO tipoProductoDTO = new TipoProductoDTO();
            tipoProductoDTO.setTipoProductos(producto.getTipoProductos());
            tipoProductoDTO.setNombre(producto.getNombre());

            //HATEOAS
            //localhost:591/tipo_productos/{id}
            WebMvcLinkBuilder linkTo1 = WebMvcLinkBuilder.linkTo(
                    WebMvcLinkBuilder.methodOn(TipoProductosController.class).findById(producto.getTipoProductos().getIdTproducto()));
            tipoProductoDTO.add(linkTo1.withSelfRel());
            dtos.add(tipoProductoDTO);
        });
        return dtos;
    }

    @Operation(summary = "Obtener una producto por el nombre",
            description = "Necesita el nombre del producto",
            method = "GET")
    @GetMapping("/name/{name}")
    public List<Productos> findByName(@PathVariable("name") String name){
        return productosService.findByNombre(name);
    }

    @Operation(summary = "Obtener una producto por el modelo",
            description = "Necesita el modelo del producto",
            method = "GET")
    @GetMapping("/model/{model}")
    public List<Productos> findByModel(@PathVariable("model") String model){
        return productosService.findByModel(model);
    }

    @Operation(summary = "Obtener un listado de productos por su cantidad",
            description = "Necesita el numero de la cantidad que se busca",
            method = "GET")
    @GetMapping("/quantity/{cantidad}")
    public List<Productos> findByQuantity(@PathVariable("cantidad") Integer cantidad){
        return productosService.findByQuantity(cantidad);
    }

    @GetMapping("/dto/listado")
    public List<ProductosDTO> findAllProductosDTO(){
        List<ProductosDTO> pdtos = new ArrayList<>();
        List<Productos> productos = productosService.findAll();
        productos.forEach(producto -> {
            ProductosDTO productosDTO = new ProductosDTO();
            productosDTO.setIdProducto(producto.getIdProducto());
            productosDTO.setNombreProducto(producto.getNombre());
            productosDTO.setCantidadProducto(producto.getCantidad());

            //marca de producto
            WebMvcLinkBuilder linkMarca = WebMvcLinkBuilder.linkTo(
                    WebMvcLinkBuilder.methodOn(MarcasController.class).findById(producto.getMarcas().getIdMarca()));
            productosDTO.add(linkMarca.withSelfRel());

            //tipo de producto
            WebMvcLinkBuilder linkToTipoProducto = WebMvcLinkBuilder.linkTo(
                    WebMvcLinkBuilder.methodOn(TipoProductosController.class).findById(producto.getTipoProductos().getIdTproducto()));
            productosDTO.add(linkToTipoProducto.withSelfRel());

            pdtos.add(productosDTO);
        });
        return pdtos;
    }

}
