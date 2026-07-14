package com.tiendavideojuego.pago.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pago")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double monto;
    private String metodo;
}