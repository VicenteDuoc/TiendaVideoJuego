package com.example.TiendaVideoJuego.model;

import jakarta.persistence.*;
import lombok.*;

@Entity// define que esta clase será una tabla en la base de datos.
@Table(name = "categorias")// la tabla en bd se va a llamar categorias
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //único y obligatorio.
    @Column(nullable = false, unique = true)
    private String nombre;

    private String descripcion;

    //sirve para mostrar "solo" categorías que estén activas.
    private Boolean activa = true;
}
