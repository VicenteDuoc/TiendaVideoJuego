package com.example.TiendaVideoJuego.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String mensaje) {
        super(mensaje);
    }
}
