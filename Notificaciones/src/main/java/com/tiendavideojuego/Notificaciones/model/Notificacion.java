package com.tiendavideojuego.Notificaciones.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notificacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;
    private String tipo;
    private String destinatario;
}