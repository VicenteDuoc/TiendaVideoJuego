package com.tiendavideojuego.producto.service;

import com.tiendavideojuego.producto.model.Producto;
import com.tiendavideojuego.producto.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {

    @Mock
    private ProductoRepository repository;

    @InjectMocks
    private ProductoService service;

    @Test
    void guardarDebePersistirProducto() {
        Producto producto = new Producto(null, "Elden Ring", 49990);
        Producto guardado = new Producto(1L, "Elden Ring", 49990);
        when(repository.save(producto)).thenReturn(guardado);

        Producto resultado = service.guardar(producto);

        assertEquals(1L, resultado.getId());
        assertEquals("Elden Ring", resultado.getNombre());
        verify(repository).save(producto);
    }

    @Test
    void buscarPorIdDebeRetornarProductoCuandoExiste() {
        Producto producto = new Producto(1L, "Zelda", 59990);
        when(repository.findById(1L)).thenReturn(Optional.of(producto));

        Optional<Producto> resultado = service.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Zelda", resultado.get().getNombre());
    }

    @Test
    void eliminarDebeBorrarCuandoExiste() {
        when(repository.existsById(1L)).thenReturn(true);

        boolean eliminado = service.eliminar(1L);

        assertTrue(eliminado);
        verify(repository).deleteById(1L);
    }

    @Test
    void eliminarDebeRetornarFalseCuandoNoExiste() {
        when(repository.existsById(99L)).thenReturn(false);

        boolean eliminado = service.eliminar(99L);

        assertFalse(eliminado);
        verify(repository, never()).deleteById(anyLong());
    }
}
