package com.tiendavideojuego.producto.repository;

import com.tiendavideojuego.producto.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepository {

    private List<Producto> lista = new ArrayList<>();
    private Long contadorId = 1L;

    public List<Producto> listar() {
        return new ArrayList<>(lista);
    }

    public Producto guardar(Producto producto) {
        if (producto.getId() == null) {
            producto.setId(contadorId++);
        }
        lista.add(producto);
        return producto;
    }

    public Producto buscarPorId(Long id) {
        for (Producto p : lista) {
            if (p.getId() != null && p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public boolean eliminar(Long id) {
        return lista.removeIf(p -> p.getId() != null && p.getId().equals(id));
    }
}