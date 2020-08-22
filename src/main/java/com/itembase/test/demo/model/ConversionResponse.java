package com.itembase.test.demo.model;

import java.util.Objects;

public class ConversionResponse {
    private String from;
    private String to;
    private Double amount;
    private Double Converted;

    public ConversionResponse() {
    }

    public ConversionResponse(String from, String to, Double amount, Double converted) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        Converted = converted;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getConverted() {
        return Converted;
    }

    public void setConverted(Double converted) {
        Converted = converted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversionResponse that = (ConversionResponse) o;
        return Objects.equals(from, that.from) &&
                Objects.equals(to, that.to) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(Converted, that.Converted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, amount, Converted);
    }

    @Override
    public String toString() {
        return "ConversionResponse{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount=" + amount +
                ", Converted=" + Converted +
                '}';
    }
}
