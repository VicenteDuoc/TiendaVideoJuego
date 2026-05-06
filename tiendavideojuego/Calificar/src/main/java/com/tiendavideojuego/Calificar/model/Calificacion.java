package com.tiendavideojuego.Calificar.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "calificacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calificacion {

    private Long id;
    private Long idJuego;
    private int puntuacion;
    private String comentario;

    public Calificacion() {
    }

    public Calificacion(Long id, Long idJuego, int puntuacion, String comentario) {
        this.id = id;
        this.idJuego = idJuego;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }

    public Long getId() {
        return id;
    }

    public Long getIdJuego() {
        return idJuego;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdJuego(Long idJuego) {
        this.idJuego = idJuego;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
