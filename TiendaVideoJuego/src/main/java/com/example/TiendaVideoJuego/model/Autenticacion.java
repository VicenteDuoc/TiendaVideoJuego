package com.example.TiendaVideoJuego.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "autenticacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Autenticacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String token;

    private Boolean activo = true;

    @Column(name = "fecha_login")
    private LocalDateTime fechaLogin;

    @PrePersist
    protected void onCreate() {
        fechaLogin = LocalDateTime.now();
    }
}