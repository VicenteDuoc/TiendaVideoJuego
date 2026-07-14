package com.tiendavideojuego.Categoria.service;

import com.tiendavideojuego.Categoria.model.Categoria;
import com.tiendavideojuego.Categoria.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public List<Categoria> listar() {
        return repository.findAll();
    }

    public Optional<Categoria> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Categoria guardar(Categoria categoria) {
        return repository.save(categoria);
    }

    public boolean eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}