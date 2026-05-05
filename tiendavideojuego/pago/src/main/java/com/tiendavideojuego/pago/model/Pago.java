package com.tiendavideojuego.pago.model;

public class Pago {
    private Long id;
    private double monto;
    private String metodo;

    public Pago() {}

    public Pago(Long id, double monto, String metodo) {
        this.id = id;
        this.monto = monto;
        this.metodo = metodo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public String getMetodo() { return metodo; }
    public void setMetodo(String metodo) { this.metodo = metodo; }
}