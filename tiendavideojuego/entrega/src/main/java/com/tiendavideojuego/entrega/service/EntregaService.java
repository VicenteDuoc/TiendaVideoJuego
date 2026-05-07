package com.tiendavideojuego.entrega.service;

import com.tiendavideojuego.entrega.model.Entrega;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntregaService {

    private List<Entrega> lista = new ArrayList<>();

    public List<Entrega> listar() {
        return lista;
    }

    public Entrega guardar(Entrega e) {
        lista.add(e);
        return e;
    }
}