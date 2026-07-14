package com.tiendavideojuego.Autenticacion.repository;

import com.tiendavideojuego.Autenticacion.model.TokenRevocado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRevocadoRepository extends JpaRepository<TokenRevocado, Long> {
    boolean existsByToken(String token);
}