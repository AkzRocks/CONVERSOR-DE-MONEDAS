package com.conversordefinitivo.modelos;
import com.conversordefinitivo.excepcion.NoExisteMonedaException;
import java.util.Map;
public class Conversion {
    private Double montoResultado;
    private Double tipoCambio;
    public Double getMontoResultado() {
        return montoResultado;
    }

    public Double getTipoCambio() {
        return tipoCambio;
    }

    Map<String, Double> divisas;

    public Map<String, Double> getDivisas() {
        return divisas;
    }

    public void Proceso(String monedaInicial, Double montoBase,
                        String monedaDeseada, Map<String, Double> divisas) {
        try {
            if (!divisas.containsKey(monedaDeseada)) {
                throw new NoExisteMonedaException("CODIGO DE MONEDA DESEADA INCORRECTO");
            } else {
                this.tipoCambio = divisas.get(monedaDeseada);
                this.montoResultado = montoBase * tipoCambio;
            }
            System.out.println("---------------------------------------------------");
            System.out.println("--> " +montoBase +" " +monedaInicial);
            System.out.println(" EQUIVALE A: ");
            System.out.println("--> " +montoResultado +" "+ monedaDeseada);
            System.out.println("---------------------------------------------------");
        } catch (NoExisteMonedaException e) {
            System.out.println(e.getMessage());
        }
    }
}

