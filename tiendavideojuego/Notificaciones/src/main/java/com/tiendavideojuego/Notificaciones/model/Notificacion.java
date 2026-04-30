package com.tiendavideojuego.Notificaciones.model;

public class Notificacion {

    private Long id;
    private String mensaje;
    private String tipo;
    private String destinatario;

    public Notificacion(Long id, String mensaje, String tipo, String destinatario) {
        this.id = id;
        this.mensaje = mensaje;
        this.tipo = tipo;
        this.destinatario = destinatario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
}
