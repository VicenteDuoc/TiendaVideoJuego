package com.tiendavideojuego.pago.service;

import com.tiendavideojuego.pago.model.Pago;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PagoService {

    private List<Pago> lista = new ArrayList<>();

    public List<Pago> listar() {
        return lista;
    }

    public Pago guardar(Pago p) {
        lista.add(p);
        return p;
    }
}