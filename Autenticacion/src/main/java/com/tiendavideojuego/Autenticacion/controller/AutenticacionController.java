package com.tiendavideojuego.Autenticacion.controller;

import com.tiendavideojuego.Autenticacion.dto.LoginRequest;
import com.tiendavideojuego.Autenticacion.service.AutenticacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AutenticacionController {

    private final AutenticacionService service;

    public AutenticacionController(AutenticacionService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
        Map<String, Object> resultado = service.login(request);
        if (resultado.containsKey("error")) {
            return ResponseEntity.status(401).body(resultado);
        }
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, Object>> logout(@RequestBody Map<String, String> body) {
        String token = body.get("token");
        Map<String, Object> resultado = service.logout(token);
        if (resultado.containsKey("error")) {
            return ResponseEntity.badRequest().body(resultado);
        }
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/validar")
    public ResponseEntity<Map<String, Object>> validar(@RequestBody Map<String, String> body) {
        String token = body.get("token");
        Map<String, Object> resultado = service.validar(token);
        return ResponseEntity.ok(resultado);
    }
}