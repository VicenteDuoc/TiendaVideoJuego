package com.tiendavideojuego.Notificaciones.service;

import com.tiendavideojuego.Notificaciones.model.Notificacion;
import com.tiendavideojuego.Notificaciones.repository.NotificacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionService {

    private final NotificacionRepository repository;

    public NotificacionService(NotificacionRepository repository) {
        this.repository = repository;
    }

    public List<Notificacion> listar(){
        return repository.findAll();
    }

    public Optional<Notificacion> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Notificacion guardar(Notificacion notificacion) {
        return repository.save(notificacion);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}