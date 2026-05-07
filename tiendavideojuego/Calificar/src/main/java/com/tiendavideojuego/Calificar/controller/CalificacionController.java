package com.tiendavideojuego.Calificar.controller;

import com.tiendavideojuego.Calificar.model.Calificacion;
import com.tiendavideojuego.Calificar.service.CalificacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CalificacionController {

    private final CalificacionService service;

    public CalificacionController(CalificacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Calificacion> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Calificacion buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Calificacion guardar(@RequestBody Calificacion calificacion) {
        return service.guardar(calificacion);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        boolean eliminado = service.eliminar(id);
        return eliminado ? "Eliminado correctamente" : "No se pudo eliminar";
    }
}