package com.conversordefinitivo.excepcion;

public class NoExisteMonedaException extends RuntimeException {
    private String mensaje;

    public NoExisteMonedaException(String mensaje) {
        this.mensaje = mensaje;
    }
    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
