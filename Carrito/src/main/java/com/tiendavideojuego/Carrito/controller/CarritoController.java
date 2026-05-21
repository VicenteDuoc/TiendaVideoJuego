package com.tiendavideojuego.Carrito.controller;

import com.tiendavideojuego.Carrito.model.CarritoItem;
import com.tiendavideojuego.Carrito.service.CarritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    private final CarritoService service;

    public CarritoController(CarritoService service) {
        this.service = service;
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<CarritoItem> listarPorUsuario(@PathVariable Long idUsuario) {
        return service.listarPorUsuario(idUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarritoItem> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CarritoItem agregar(@RequestBody CarritoItem item) {
        return service.agregar(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarritoItem> actualizar(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        Integer nuevaCantidad = body.get("cantidad");
        return service.actualizarCantidad(id, nuevaCantidad)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarItem(@PathVariable Long id) {
        if (service.eliminarItem(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/usuario/{idUsuario}")
    public ResponseEntity<Void> vaciarCarrito(@PathVariable Long idUsuario) {
        service.vaciarCarrito(idUsuario);
        return ResponseEntity.noContent().build();
    }
}