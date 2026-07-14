package com.tiendavideojuego.Registro.service;

import com.tiendavideojuego.Registro.model.Rol;
import com.tiendavideojuego.Registro.model.Usuario;
import com.tiendavideojuego.Registro.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioService service;

    @Test
    void actualizarDebeModificarSoloDatosPresentes() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Antiguo");
        usuario.setEmail("old@test.cl");
        usuario.setRol(Rol.USER);

        Usuario datos = new Usuario();
        datos.setNombre("Nuevo");
        datos.setRol(Rol.ADMIN);

        when(repository.findById(1L)).thenReturn(Optional.of(usuario));
        when(repository.save(usuario)).thenReturn(usuario);

        Optional<Usuario> resultado = service.actualizar(1L, datos);

        assertTrue(resultado.isPresent());
        assertEquals("Nuevo", resultado.get().getNombre());
        assertEquals("old@test.cl", resultado.get().getEmail());
        assertEquals(Rol.ADMIN, resultado.get().getRol());
    }

    @Test
    void desactivarDebeMarcarUsuarioComoInactivo() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setActivo(true);
        when(repository.findById(1L)).thenReturn(Optional.of(usuario));

        boolean resultado = service.desactivar(1L);

        assertTrue(resultado);
        assertFalse(usuario.getActivo());
        verify(repository).save(usuario);
    }

    @Test
    void validarPasswordDebeCompararPasswords() {
        assertTrue(service.validarPassword("abc123", "abc123"));
        assertFalse(service.validarPassword("abc123", "otro"));
    }
}
