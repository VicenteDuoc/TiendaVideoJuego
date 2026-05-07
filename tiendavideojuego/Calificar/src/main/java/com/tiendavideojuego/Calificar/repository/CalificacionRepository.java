package com.tiendavideojuego.Calificar.repository;

import com.tiendavideojuego.Calificar.model.Calificacion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CalificacionRepository {

    private List<Calificacion> lista = new ArrayList<>();
    private Long contadorId = 1L;

    public List<Calificacion> listar() {
        return new ArrayList<>(lista);
    }

    public Calificacion guardar(Calificacion calificacion) {
        if (calificacion.getId() == null) {
            calificacion.setId(contadorId++);
        }

        lista.add(calificacion);
        return calificacion;
    }

    public Calificacion buscarPorId(Long id) {
        for (Calificacion c : lista) {
            if (c.getId() != null && c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public boolean eliminar(Long id) {
        return lista.removeIf(c -> c.getId() != null && c.getId().equals(id));
    }
}