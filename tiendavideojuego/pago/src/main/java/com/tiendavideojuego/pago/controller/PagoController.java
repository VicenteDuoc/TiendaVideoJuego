package com.tiendavideojuego.pago.controller;

import com.tiendavideojuego.pago.model.Pago;
import com.tiendavideojuego.pago.service.PagoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pago")
public class PagoController {

    private final PagoService service;

    public PagoController(PagoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pago> listar() {
        return service.listar();
    }

    @PostMapping
    public Pago guardar(@RequestBody Pago p) {
        return service.guardar(p);
    }
}