package com.tiendavideojuego.Notificaciones.controller;

import com.tiendavideojuego.Notificaciones.model.Notificacion;
import com.tiendavideojuego.Notificaciones.service.NotificacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NotificacionController {

    private final NotificacionService service;

    public NotificacionController(NotificacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Notificacion> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Notificacion buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Notificacion guardar(@RequestBody Notificacion notificacion) {
        return service.guardar(notificacion);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        boolean eliminado = service.eliminar(id);
        return eliminado ? "Eliminado correctamente" : "No se pudo eliminar";
    }
}
