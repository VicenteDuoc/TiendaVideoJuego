package com.example.TiendaVideoJuego.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity // define que esta clase será una tabla en la base de datos.
@Table(name = "tienda")//aca se asigna el nombre de la tabla en la base de datos.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // Builder te permite crear objetos como por ejemplo una tienda.builder la cual va a tener todos los atributos de Tienda.java
public class Tienda {

    @Id // esto se utiliza para que no se tenga que tipear una clave primaria como tal, ya que el mismo @Id es una.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ejecuta de manera automática un, Id que es auto-incremental por el IDENTITY
    private Long id;

    @Column(nullable = false)
    private String  nombre;

    private String  descripcion;
    private String  direccion;
    private String  email;
    private String  telefono;
    private Boolean abierta = true;

    //@Column se utiliza para que el programa le diga a la base de datos que quieres guardar un dato de una forma específica.
    //En este caso no indíca es nullable asi que es de tipo opcional y no obligatoria.
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    //Esta anotacion se ejecuta antes de ir a la base de datos, en este sentido toma la fecha actual y la inserta automaticamente en la BD.
    @PrePersist
    protected void setFechaCreacion(){
        fechaCreacion = LocalDateTime.now();
    }
}
