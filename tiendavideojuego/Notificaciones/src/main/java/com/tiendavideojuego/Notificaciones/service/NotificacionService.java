package com.tiendavideojuego.Notificaciones.service;

import com.tiendavideojuego.Notificaciones.model.Notificacion;
import com.tiendavideojuego.Notificaciones.repository.NotificacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionService {

    private final NotificacionRepository repository;

    public NotificacionService(NotificacionRepository repository) {
        this.repository = repository;
    }

    public List<Notificacion> listar() {
        return repository.listar();
    }

    public Notificacion buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

    public Notificacion guardar(Notificacion notificacion) {
        return repository.guardar(notificacion);
    }

    public boolean eliminar(Long id) {
        return repository.eliminar(id);
    }
}