package com.tiendavideojuego.Pedido.service;

import com.tiendavideojuego.Pedido.model.EstadoPedido;
import com.tiendavideojuego.Pedido.model.Pedido;
import com.tiendavideojuego.Pedido.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public List<Pedido> listar() {
        return repository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Pedido> listarPorUsuario(Long idUsuario) {
        return repository.findByIdUsuario(idUsuario);
    }

    public Pedido guardar(Pedido pedido) {
        return repository.save(pedido);
    }

    public Optional<Pedido> cambiarEstado(Long id, EstadoPedido nuevoEstado) {
        return repository.findById(id).map(pedido -> {
            pedido.setEstado(nuevoEstado);
            return repository.save(pedido);
        });
    }

    /**
     * Cancela un pedido cambiando su estado a CANCELADO.
     */
    public Optional<Pedido> cancelar(Long id) {
        return repository.findById(id).map(pedido -> {
            pedido.setEstado(EstadoPedido.CANCELADO);
            return repository.save(pedido);
        });
    }

    /**
     * Elimina un pedido fisicamente de la base de datos.
     */
    public boolean eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}