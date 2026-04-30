package com.tiendavideojuego.Notificaciones.repository;

import com.tiendavideojuego.Notificaciones.model.Notificacion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NotificacionRepository {

    private List<Notificacion> lista = new ArrayList<>();
    private Long contadorId = 1L;

    public List<Notificacion> listar() {
        return new ArrayList<>(lista);
    }

    public Notificacion guardar(Notificacion notificacion) {
        if (notificacion.getId() == null) {
            notificacion.setId(contadorId++);
        }

        lista.add(notificacion);
        return notificacion;
    }

    public Notificacion buscarPorId(Long id) {
        for (Notificacion n : lista) {
            if (n.getId() != null && n.getId().equals(id)) {
                return n;
            }
        }
        return null;
    }

    public boolean eliminar(Long id) {
        return lista.removeIf(n -> n.getId() != null && n.getId().equals(id));
    }
}