package com.tiendavideojuego.Categoria.repository;

import com.tiendavideojuego.Categoria.model.Categoria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoriaRepository {

    private List<Categoria> lista = new ArrayList<>();
    private Long contadorId = 1L;

    public List<Categoria> listar() {
        return new ArrayList<>(lista);
    }

    public Categoria guardar(Categoria categoria) {
        if (categoria.getId() == null) {
            categoria.setId(contadorId++);
        }

        lista.add(categoria);
        return categoria;
    }

    public Categoria buscarPorId(Long id) {
        for(Categoria c : lista) {
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
