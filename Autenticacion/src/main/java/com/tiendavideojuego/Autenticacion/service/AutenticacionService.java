package com.tiendavideojuego.Autenticacion.service;

import com.tiendavideojuego.Autenticacion.dto.LoginRequest;
import com.tiendavideojuego.Autenticacion.dto.UsuarioDTO;
import com.tiendavideojuego.Autenticacion.model.TokenRevocado;
import com.tiendavideojuego.Autenticacion.repository.TokenRevocadoRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AutenticacionService {

    private final RegistroClient registroClient;
    private final JwtService jwtService;
    private final TokenRevocadoRepository tokenRevocadoRepository;

    public AutenticacionService(RegistroClient registroClient,
                                JwtService jwtService,
                                TokenRevocadoRepository tokenRevocadoRepository) {
        this.registroClient = registroClient;
        this.jwtService = jwtService;
        this.tokenRevocadoRepository = tokenRevocadoRepository;
    }

    public Map<String, Object> login(LoginRequest request) {
        Optional<UsuarioDTO> usuarioOpt = registroClient.buscarPorEmail(request.getEmail());

        if (usuarioOpt.isEmpty()) {
            return Map.of("error", "Usuario no encontrado");
        }

        UsuarioDTO usuario = usuarioOpt.get();

        if (!Boolean.TRUE.equals(usuario.getActivo())) {
            return Map.of("error", "Usuario desactivado");
        }

        if (!usuario.getPassword().equals(request.getPassword())) {
            return Map.of("error", "Password incorrecta");
        }

        String token = jwtService.generarToken(usuario);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("token", token);
        respuesta.put("usuario", Map.of(
                "id", usuario.getId(),
                "nombre", usuario.getNombre(),
                "email", usuario.getEmail(),
                "rol", usuario.getRol()
        ));
        return respuesta;
    }

    public Map<String, Object> logout(String token) {
        if (tokenRevocadoRepository.existsByToken(token)) {
            return Map.of("mensaje", "El token ya estaba revocado");
        }

        try {
            String email = jwtService.extraerEmail(token);
            Long idUsuario = jwtService.extraerClaims(token).get("id", Long.class);

            TokenRevocado revocado = new TokenRevocado();
            revocado.setToken(token);
            revocado.setEmail(email);
            revocado.setIdUsuario(idUsuario);
            tokenRevocadoRepository.save(revocado);

            return Map.of("mensaje", "Logout exitoso");
        } catch (Exception e) {
            return Map.of("error", "Token invalido");
        }
    }

    public Map<String, Object> validar(String token) {
        if (tokenRevocadoRepository.existsByToken(token)) {
            return Map.of("valido", false, "razon", "Token revocado");
        }

        if (!jwtService.esTokenValido(token)) {
            return Map.of("valido", false, "razon", "Token expirado o invalido");
        }

        try {
            return Map.of(
                    "valido", true,
                    "email", jwtService.extraerEmail(token),
                    "id", jwtService.extraerClaims(token).get("id"),
                    "rol", jwtService.extraerClaims(token).get("rol")
            );
        } catch (Exception e) {
            return Map.of("valido", false, "razon", "Error al procesar token");
        }
    }
}