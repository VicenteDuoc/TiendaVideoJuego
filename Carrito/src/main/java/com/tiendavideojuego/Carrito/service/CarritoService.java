package com.tiendavideojuego.Carrito.service;

import com.tiendavideojuego.Carrito.model.CarritoItem;
import com.tiendavideojuego.Carrito.repository.CarritoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {

    private final CarritoRepository repository;

    public CarritoService(CarritoRepository repository) {
        this.repository = repository;
    }

    public List<CarritoItem> listarPorUsuario(Long idUsuario) {
        return repository.findByIdUsuario(idUsuario);
    }

    public Optional<CarritoItem> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public CarritoItem agregar(CarritoItem item) {
        return repository.save(item);
    }

    public Optional<CarritoItem> actualizarCantidad(Long id, Integer nuevaCantidad) {
        return repository.findById(id).map(item -> {
            item.setCantidad(nuevaCantidad);
            return repository.save(item);
        });
    }

    public boolean eliminarItem(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public void vaciarCarrito(Long idUsuario) {
        repository.deleteByIdUsuario(idUsuario);
    }
}