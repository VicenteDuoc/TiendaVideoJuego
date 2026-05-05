package com.tiendavideojuego.entrega.repository;

import com.tiendavideojuego.entrega.model.Entrega;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntregaRepository {

    private List<Entrega> lista = new ArrayList<>();
    private Long contadorId = 1L;

    public List<Entrega> listar() {
        return new ArrayList<>(lista);
    }

    public Entrega guardar(Entrega entrega) {
        if (entrega.getId() == null) {
            entrega.setId(contadorId++);
        }
        lista.add(entrega);
        return entrega;
    }

    public Entrega buscarPorId(Long id) {
        for (Entrega e : lista) {
            if (e.getId() != null && e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public boolean eliminar(Long id) {
        return lista.removeIf(e -> e.getId() != null && e.getId().equals(id));
    }
}