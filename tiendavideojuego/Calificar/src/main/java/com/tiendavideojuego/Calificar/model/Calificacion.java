package com.tiendavideojuego.Calificar.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "calificacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idJuego;
    private int puntuacion;
    private String comentario;
}