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

    //Esta anotación permite que JPA guarde el valor como tipo texto dentro de la base de datos que estamos haciendo//
    @Enumerated(EnumType.STRING)
    private Estado estado;
}