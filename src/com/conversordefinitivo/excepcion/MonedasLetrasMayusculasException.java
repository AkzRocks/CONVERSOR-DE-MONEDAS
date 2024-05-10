package com.conversordefinitivo.excepcion;

public class MonedasLetrasMayusculasException extends RuntimeException {

    private String mensaje;

    public MonedasLetrasMayusculasException(String mensaje) {
            this.mensaje = mensaje;
        }
        @Override
        public String getMessage() {
            return this.mensaje;
        }
}
