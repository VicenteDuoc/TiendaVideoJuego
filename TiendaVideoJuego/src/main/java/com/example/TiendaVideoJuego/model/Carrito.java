package com.example.TiendaVideoJuego.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity//define que esta clase será una tabla en la base de datos.
@Table(name = "carritos")// esta tabla se va a llamar carritos en BD
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //aca se define el nombre de la columna en la base de datos que va a ser en este caso "usuarios_id"
    @Column(name = "usuarios_id", nullable = false)
    private Long usuarioId;

    //permite un maximo de 10 numeros con dos decimales maximo, no puede sobrepasar las condiciones.
    @Column(precision = 10, scale = 2)
    private BigDecimal total;

    private Boolean activo = true;

    //aca se define el nombre de la columna en la base de datos que va a ser en este caso "fecha_creacion"
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @PrePersist
    protected void onCreate(){
        fechaCreacion = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetalleCarrito> detalles;
}
