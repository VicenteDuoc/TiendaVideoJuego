package com.tiendavideojuego.Calificar.service;

import com.tiendavideojuego.Calificar.model.Calificacion;
import com.tiendavideojuego.Calificar.repository.CalificacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionService {

    private final CalificacionRepository repository;

    public CalificacionService(CalificacionRepository repository) {
        this.repository = repository;
    }

    public List<Calificacion> listar() {
        return repository.listar();
    }

    public Calificacion buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

    public Calificacion guardar(Calificacion calificacion) {
        return repository.guardar(calificacion);
    }

    public boolean eliminar(Long id) {
        return repository.eliminar(id);
    }
}