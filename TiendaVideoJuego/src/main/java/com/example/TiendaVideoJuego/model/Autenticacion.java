package com.example.TiendaVideoJuego.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity// define que esta clase será una tabla en la base de datos.
@Table(name = "autenticacion")//nombre de la tabla en la bd
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Autenticacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //hace que email sea obligatorio y único
    @Column(nullable = false, unique = true)
    private String email;

    //Hace que password sea obligatorio
    @Column(nullable = false)
    private String password;

    private String token;
    private Boolean activo = true;

    //registro automático de fecha con @Column
    @Column(name = "fecha_login")
    private LocalDateTime fechalogin;
}
