package com.conversordefinitivo.modelos;

import java.util.Map;

public record ConversionGson(Map<String, Double> conversion_rates) {
    @Override
    public Map<String, Double> conversion_rates() {
        return conversion_rates;
    }
}
