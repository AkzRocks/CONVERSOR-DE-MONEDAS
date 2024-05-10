package com.conversordefinitivo.excepcion;

public class ElMontoPositivoException extends RuntimeException {
    private String mensaje;
    public ElMontoPositivoException(String mensaje) {
        this.mensaje = mensaje;
    }
    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
