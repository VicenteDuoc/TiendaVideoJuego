package com.tiendavideojuego.Carrito.repository;

import com.tiendavideojuego.Carrito.model.CarritoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarritoRepository extends JpaRepository<CarritoItem, Long> {
    List<CarritoItem> findByIdUsuario(Long idUsuario);
    void deleteByIdUsuario(Long idUsuario);
}