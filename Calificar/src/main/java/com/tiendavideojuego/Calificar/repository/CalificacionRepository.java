package com.tiendavideojuego.Calificar.repository;

import com.tiendavideojuego.Calificar.model.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
}