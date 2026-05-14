package com.tiendavideojuego.entrega.service;

import com.tiendavideojuego.entrega.model.Entrega;
import com.tiendavideojuego.entrega.repository.EntregaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregaService {

    private final EntregaRepository repository;

    public EntregaService(EntregaRepository repository) {
        this.repository = repository;
    }

    public List<Entrega> listar() {
        return repository.findAll();
    }

    public Optional<Entrega> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Entrega guardar(Entrega entrega) {
        return repository.save(entrega);
    }

    public boolean eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}