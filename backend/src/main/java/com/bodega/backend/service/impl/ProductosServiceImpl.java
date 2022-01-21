package com.bodega.backend.service.impl;

import com.bodega.backend.dto.ProductosDTO;
import com.bodega.backend.dto.TipoProductoDTO;
import com.bodega.backend.exception.ModelNoFoundException;
import com.bodega.backend.model.Productos;
import com.bodega.backend.repository.ProductosRepository;
import com.bodega.backend.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductosServiceImpl implements ProductosService {
    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    public ProductosServiceImpl(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    @Override
    public List<Productos> findAll() {
        return productosRepository.findAll();
    }

    @Override
    public Productos findById(Integer id) {
        Optional<Productos> producto = productosRepository.findById(id);
        if (producto.isPresent()){
            return producto.get();
        }else{
            throw new ModelNoFoundException("Producto no encontrado");
        }
    }

    @Override
    public Productos save(Productos productos) {
        return productosRepository.save(productos);
    }

    @Override
    public Productos update(Productos productos) {
        return save(productos);
    }

    @Override
    public boolean delete(Integer id) {
        productosRepository.deleteById(id);
        return true;
    }

    @Override
    public List<TipoProductoDTO> findAllDto() {
        List<TipoProductoDTO> dtos = new ArrayList<>();
        List<Productos> productos = productosRepository.findAll();
        productos.forEach(producto ->{
             TipoProductoDTO tipoProductoDTO = new TipoProductoDTO();
             tipoProductoDTO.setIdProducto(producto.getIdProducto());
             tipoProductoDTO.setNombre(producto.getNombre());
             tipoProductoDTO.setTipoProductos(producto.getTipoProductos());
             dtos.add(tipoProductoDTO);
        });
        return dtos;
    }

    @Override
    public List<Productos> findByNombre(String nombre) {
        return productosRepository.findAllByNombre(nombre);
    }

    @Override
    public List<Productos> findByModel(String modelo) {
        return productosRepository.findAllByModelo(modelo);
    }

    @Override
    public List<Productos> findByQuantity(Integer cantidad) {
        return productosRepository.findAllByCantidad(cantidad);
    }

    public List<ProductosDTO> findAllProductosDTO() {
        List<ProductosDTO> pdtos = new ArrayList<>();
        List<Productos> productos = productosRepository.findAll();
        productos.forEach(producto -> {
            ProductosDTO productosDTO = new ProductosDTO();
            productosDTO.setIdProducto(producto.getIdProducto());
            productosDTO.setNombreProducto(producto.getNombre());
            productosDTO.setNombreMarca(producto.getMarcas().getNombre());
            productosDTO.setNombreTipoProducto(producto.getTipoProductos().getNombre());
            productosDTO.setCantidadProducto(producto.getCantidad());
            pdtos.add(productosDTO);
        });
        return pdtos;
    }
}
