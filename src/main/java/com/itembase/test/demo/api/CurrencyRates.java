package com.itembase.test.demo.api;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CurrencyRates {
    private Map<String, Double> rates = Collections.emptyMap();

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double>  rates) {
        this.rates = rates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyRates that = (CurrencyRates) o;
        return Objects.equals(rates, that.rates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rates);
    }

    @Override
    public String toString() {
        return "CurrencyRates{" +
                "rates=" + rates +
                '}';
    }
}
