package com.tiendavideojuego.entrega.controller;

import com.tiendavideojuego.entrega.model.Entrega;
import com.tiendavideojuego.entrega.service.EntregaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrega")
public class EntregaController {

    private final EntregaService service;

    public EntregaController(EntregaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Entrega> listar() {
        return service.listar();
    }

    @PostMapping
    public Entrega guardar(@RequestBody Entrega e) {
        return service.guardar(e);
    }
}