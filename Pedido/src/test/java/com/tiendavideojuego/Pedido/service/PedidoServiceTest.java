package com.tiendavideojuego.Pedido.service;

import com.tiendavideojuego.Pedido.model.EstadoPedido;
import com.tiendavideojuego.Pedido.model.Pedido;
import com.tiendavideojuego.Pedido.repository.PedidoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PedidoServiceTest {

    @Mock
    private PedidoRepository repository;

    @InjectMocks
    private PedidoService service;

    @Test
    void cambiarEstadoDebeGuardarNuevoEstado() {
        Pedido pedido = new Pedido();
        pedido.setId(1L);
        pedido.setEstado(EstadoPedido.PENDIENTE);
        when(repository.findById(1L)).thenReturn(Optional.of(pedido));
        when(repository.save(pedido)).thenReturn(pedido);

        Optional<Pedido> resultado = service.cambiarEstado(1L, EstadoPedido.CONFIRMADO);

        assertTrue(resultado.isPresent());
        assertEquals(EstadoPedido.CONFIRMADO, resultado.get().getEstado());
        verify(repository).save(pedido);
    }

    @Test
    void cancelarDebeCambiarEstadoACancelado() {
        Pedido pedido = new Pedido();
        pedido.setId(1L);
        pedido.setEstado(EstadoPedido.PENDIENTE);
        when(repository.findById(1L)).thenReturn(Optional.of(pedido));
        when(repository.save(pedido)).thenReturn(pedido);

        Optional<Pedido> resultado = service.cancelar(1L);

        assertTrue(resultado.isPresent());
        assertEquals(EstadoPedido.CANCELADO, resultado.get().getEstado());
    }

    @Test
    void cambiarEstadoDebeRetornarEmptyCuandoNoExiste() {
        when(repository.findById(50L)).thenReturn(Optional.empty());

        Optional<Pedido> resultado = service.cambiarEstado(50L, EstadoPedido.ENVIADO);

        assertTrue(resultado.isEmpty());
        verify(repository, never()).save(any());
    }
}
