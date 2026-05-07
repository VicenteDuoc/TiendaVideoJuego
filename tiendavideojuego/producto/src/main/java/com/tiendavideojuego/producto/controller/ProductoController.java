package com.tiendavideojuego.producto.controller;

import com.tiendavideojuego.producto.model.Producto;
import com.tiendavideojuego.producto.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Producto> listar() {
        return service.listar();
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto p) {
        return service.guardar(p);
    }
}