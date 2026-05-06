package com.tiendavideojuego.entrega.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "entrega")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entrega {
    private Long id;
    private String direccion;
    private String estado;

    public Entrega() {}

    public Entrega(Long id, String direccion, String estado) {
        this.id = id;
        this.direccion = direccion;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}