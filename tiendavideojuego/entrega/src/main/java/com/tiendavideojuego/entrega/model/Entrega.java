package com.tiendavideojuego.entrega.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "entrega")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;
    private String estado;
}