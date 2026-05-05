package com.tiendavideojuego.producto.service;

import com.tiendavideojuego.producto.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    private List<Producto> lista = new ArrayList<>();

    public List<Producto> listar() {
        return lista;
    }

    public Producto guardar(Producto p) {
        lista.add(p);
        return p;
    }
}