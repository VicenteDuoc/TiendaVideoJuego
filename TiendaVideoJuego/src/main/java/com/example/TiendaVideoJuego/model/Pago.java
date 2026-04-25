package com.example.TiendaVideoJuego.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pedido_id", nullable = false)
    private Long pedidoId;

    @Column(name = "usuario_id", nullable = false)
    private long usuarioId;

    private String metodoPago;

    @Column(precision = 10, scale = 2)
    private BigDecimal monto;

    private String estado;

    private String referencia;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;

    @PrePersist
    protected void onCreate(){
        fechaPago = LocalDateTime.now();
        estado = "PENDIENTE";
    }
}
