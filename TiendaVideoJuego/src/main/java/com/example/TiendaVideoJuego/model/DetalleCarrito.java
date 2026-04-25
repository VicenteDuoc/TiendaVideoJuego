package com.example.TiendaVideoJuego.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity// define que esta clase será una tabla en la base de datos.
@Table(name = "detalle_carrito")// esta tabla se llama detalle_carrito dentro de la BD
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleCarrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carrito_id")
    private Carrito carrito;

    @Column(name = "producto_id", nullable = false)
    private Long productoId;

    private String nombreProducto;

    private Integer cantidad;

    //BigDecimal hace que de números decimales sin margen de error, no se ocupa double porque trabaja en binario y pierde precision
    //esto se traduce en la BD como: DECIMAL(10, 2), permite hasta 10 números con un decimal de 2, no puede sobrepasar
    @Column(precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    //esto se traduce en la BD como: DECIMAL(10, 2), permite hasta 10 números con un decimal de 2, no puede sobrepasar
    @Column(precision = 10, scale = 2)
    private BigDecimal subtotal;
}