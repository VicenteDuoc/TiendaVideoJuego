package com.tiendavideojuego.Autenticacion.service;

import com.tiendavideojuego.Autenticacion.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class RegistroClient {

    private final WebClient webClient;

    @Value("${registro.url}")
    private String registroUrl;

    public RegistroClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Optional<UsuarioDTO> buscarPorEmail(String email) {
        try {
            UsuarioDTO usuario = webClient.get()
                    .uri(registroUrl + "/registro/email/" + email)
                    .retrieve()
                    .bodyToMono(UsuarioDTO.class)
                    .block(); // block() porque queremos esperar la respuesta

            return Optional.ofNullable(usuario);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}