package com.tiendavideojuego.Registro.service;

import com.tiendavideojuego.Registro.model.Usuario;
import com.tiendavideojuego.Registro.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listarActivos() {
        return repository.findByActivoTrue();
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return repository.findByEmail(email);
    }

    public Usuario crear(Usuario usuario) {
        return repository.save(usuario);
    }

    public Optional<Usuario> actualizar(Long id, Usuario datos) {
        return repository.findById(id).map(usuario -> {
            if (datos.getNombre() != null) usuario.setNombre(datos.getNombre());
            if (datos.getRol() != null) usuario.setRol(datos.getRol());
            if (datos.getEmail() != null) usuario.setEmail(datos.getEmail());
            return repository.save(usuario);
        });
    }

    public Optional<Usuario> cambiarPassword(Long id, String nuevaPassword) {
        return repository.findById(id).map(usuario -> {
            usuario.setPassword(nuevaPassword);
            return repository.save(usuario);
        });
    }

    public boolean desactivar(Long id) {
        return repository.findById(id).map(usuario -> {
            usuario.setActivo(false);
            repository.save(usuario);
            return true;
        }).orElse(false);
    }

    public boolean validarPassword(String passwordPlana, String passwordGuardada) {
        return passwordPlana.equals(passwordGuardada);
    }
}