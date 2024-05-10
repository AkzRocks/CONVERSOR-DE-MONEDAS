package com.conversordefinitivo.modelos;

import com.conversordefinitivo.excepcion.NoExisteMonedaException;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
public class Busqueda extends Datos {
    public Map<String, Double> getDivisas() {
        return divisas;
    }

    Map<String, Double> divisas;
    public void BusquedaConversiones (String monedaInicial) {
        try {
            String direccion = "https://v6.exchangerate-api.com/v6/2c8844a16eeec08d6ae6b06c/latest/" + monedaInicial;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String miJson = response.body();
            if (!miJson.contains(monedaInicial)){
                throw new NoExisteMonedaException("CODIGO DE MONEDA INICIAL INCORRECTO");
            } else{
                ConversionGson conversionGson = new Gson().fromJson(miJson, ConversionGson.class);
                divisas = conversionGson.conversion_rates();
            }
        } catch (IllegalArgumentException | NoExisteMonedaException | IOException | InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}