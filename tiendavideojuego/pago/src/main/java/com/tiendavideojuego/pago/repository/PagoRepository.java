package com.tiendavideojuego.pago.repository;

import com.tiendavideojuego.pago.model.Pago;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PagoRepository {

    private List<Pago> lista = new ArrayList<>();
    private Long contadorId = 1L;

    public List<Pago> listar() {
        return new ArrayList<>(lista);
    }

    public Pago guardar(Pago pago) {
        if (pago.getId() == null) {
            pago.setId(contadorId++);
        }
        lista.add(pago);
        return pago;
    }

    public Pago buscarPorId(Long id) {
        for (Pago p : lista) {
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