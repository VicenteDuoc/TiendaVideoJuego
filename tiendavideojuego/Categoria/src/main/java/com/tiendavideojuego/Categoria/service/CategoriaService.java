package com.tiendavideojuego.Categoria.service;

import com.tiendavideojuego.Categoria.model.Categoria;
import com.tiendavideojuego.Categoria.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public List<Categoria> listar() {
        return repository.listar();
    }

    public Categoria guardar(Categoria categoria) {
        return repository.guardar(categoria);
    }

    public Categoria buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

    public boolean eliminar(Long id) {
        return repository.eliminar(id);
    }
}
