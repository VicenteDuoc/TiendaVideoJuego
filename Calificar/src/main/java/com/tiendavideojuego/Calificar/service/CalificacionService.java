package com.tiendavideojuego.Calificar.service;

import com.tiendavideojuego.Calificar.model.Calificacion;
import com.tiendavideojuego.Calificar.repository.CalificacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionService {

    private final CalificacionRepository repository;

    public CalificacionService(CalificacionRepository repository) {
        this.repository = repository;
    }

    public List<Calificacion> listar() {
        return repository.findAll();
    }

    public Optional<Calificacion> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Calificacion guardar(Calificacion calificacion) {
        return repository.save(calificacion);
    }

    public boolean eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}