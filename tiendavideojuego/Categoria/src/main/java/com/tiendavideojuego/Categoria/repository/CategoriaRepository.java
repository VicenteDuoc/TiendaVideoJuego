package com.tiendavideojuego.Categoria.repository;

import com.tiendavideojuego.Categoria.model.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaRepository {

    private List<Categoria> lista = new ArrayList<>();

    public List<Categoria> listar() {
        return lista;
    }

    public void guardar(Categoria categoria) {
        lista.add(categoria);
    }

    public Categoria buscarPorId(Long id) {
        for(Categoria c : lista) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public void eliminar(Long id) {
        lista.removeIf(c -> c.getId().equals(id));
    }
}
