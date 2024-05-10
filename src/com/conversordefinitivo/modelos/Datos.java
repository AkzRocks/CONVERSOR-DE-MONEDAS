package com.conversordefinitivo.modelos;

import com.conversordefinitivo.excepcion.ElMontoPositivoException;
import com.conversordefinitivo.excepcion.MonedasLetrasMayusculasException;
import java.util.Scanner;

public class Datos {
    private String monedaInicial, monedaDeseada;
    private double montoBase;
    private boolean datosErrados;
    private boolean exit;
    String ingreso = "[A-Z]{3}";
    Scanner entrada = new Scanner(System.in);
    String mensaje = """
                        ----------BIENVENIDO AL CONVERSOR DE MONEDAS----------
                        ----COVIERTE LAS MONEDAS USANDO CÓDIGOS DE MONEDAS---- 
                        (codigos de estándar ISO 4217, tres letras mayusculas)""";

    public boolean isDatosErrados() {
        return datosErrados;
    }
    public boolean isExit() {
        return exit;
    }

    public String getMonedaInicial() {
        return monedaInicial;
    }
    public String getMonedaDeseada() {
        return monedaDeseada;
    }

    public Double getMontoBase() {
        return montoBase;
    }

    public void Fachada() {
        System.out.println(mensaje);
        try {
            System.out.println("Ingresa su moneda base");
            this.monedaInicial = entrada.nextLine();
            if (getMonedaInicial().isEmpty()) {
                this.exit = true;
            } else if (!this.monedaInicial.matches(ingreso)) {
                throw new MonedasLetrasMayusculasException("La moneda ingresada no cumple en codigo ISO 4217");
            } else {

                System.out.println("Ingresa moneda de cotización:");
                this.monedaDeseada = entrada.nextLine();
                if (getMonedaDeseada().isEmpty()) {
                    this.exit = true;
                } else if (!getMonedaDeseada().matches(ingreso)) {
                    throw new MonedasLetrasMayusculasException("La moneda ingresada no cumple en cdigo ISO 4217");
                } else {
                    System.out.println("Ingresa el monto deseado:");
                    this.montoBase = entrada.nextDouble();
                    if (getMontoBase().isNaN()) {
                        this.exit = true;
                    } else {
                        if (getMontoBase() <= 0) {
                            throw new ElMontoPositivoException("El monto ingresado no es positivo");
                        }
                    }
                }
            }
        } catch (MonedasLetrasMayusculasException | ElMontoPositivoException e) {
            System.out.println(e.getMessage());
            this.datosErrados = true;
        } catch (NumberFormatException e) {
            System.out.println("Monto no es positivo");
            this.datosErrados = true;
        }
    }
}


