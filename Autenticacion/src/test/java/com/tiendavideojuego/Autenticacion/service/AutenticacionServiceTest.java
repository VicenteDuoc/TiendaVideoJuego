package com.tiendavideojuego.Autenticacion.service;

import com.tiendavideojuego.Autenticacion.dto.LoginRequest;
import com.tiendavideojuego.Autenticacion.dto.UsuarioDTO;
import com.tiendavideojuego.Autenticacion.model.TokenRevocado;
import com.tiendavideojuego.Autenticacion.repository.TokenRevocadoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AutenticacionServiceTest {

    @Mock
    private RegistroClient registroClient;

    @Mock
    private JwtService jwtService;

    @Mock
    private TokenRevocadoRepository tokenRevocadoRepository;

    @InjectMocks
    private AutenticacionService service;

    @Test
    void loginDebeRetornarTokenCuandoCredencialesSonCorrectas() {
        UsuarioDTO usuario = new UsuarioDTO(1L, "Ana", "ana@test.cl", "1234", "USER", true);
        when(registroClient.buscarPorEmail("ana@test.cl")).thenReturn(Optional.of(usuario));
        when(jwtService.generarToken(usuario)).thenReturn("jwt-token");

        Map<String, Object> respuesta = service.login(new LoginRequest("ana@test.cl", "1234"));

        assertEquals("jwt-token", respuesta.get("token"));
        assertTrue(respuesta.containsKey("usuario"));
    }

    @Test
    void loginDebeRechazarPasswordIncorrecta() {
        UsuarioDTO usuario = new UsuarioDTO(1L, "Ana", "ana@test.cl", "1234", "USER", true);
        when(registroClient.buscarPorEmail("ana@test.cl")).thenReturn(Optional.of(usuario));

        Map<String, Object> respuesta = service.login(new LoginRequest("ana@test.cl", "mala"));

        assertEquals("Password incorrecta", respuesta.get("error"));
        verify(jwtService, never()).generarToken(any());
    }

    @Test
    void logoutDebeGuardarTokenRevocado() {
        when(tokenRevocadoRepository.existsByToken("token")).thenReturn(false);
        when(jwtService.extraerEmail("token")).thenReturn("ana@test.cl");
        when(jwtService.extraerClaims("token")).thenReturn(io.jsonwebtoken.Jwts.claims()
                .add("id", 1L)
                .build());

        Map<String, Object> respuesta = service.logout("token");

        assertEquals("Logout exitoso", respuesta.get("mensaje"));
        ArgumentCaptor<TokenRevocado> captor = ArgumentCaptor.forClass(TokenRevocado.class);
        verify(tokenRevocadoRepository).save(captor.capture());
        assertEquals("token", captor.getValue().getToken());
        assertEquals("ana@test.cl", captor.getValue().getEmail());
    }

    @Test
    void validarDebeRechazarTokenRevocado() {
        when(tokenRevocadoRepository.existsByToken("token")).thenReturn(true);

        Map<String, Object> respuesta = service.validar("token");

        assertEquals(false, respuesta.get("valido"));
        assertEquals("Token revocado", respuesta.get("razon"));
    }
}
