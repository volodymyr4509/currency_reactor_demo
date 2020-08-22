package com.itembase.test.demo.model;

import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ConversionRequest {

    @NotNull
    @Size(min=3, max=3, message = "wrong currency format")
    private String from;
    @NotNull
    @Size(min=3, max=3, message = "wrong currency format")
    private String to;
    @NotNull
    private Double amount;

    public ConversionRequest(@NotNull @Size(min = 3, max = 3, message = "wrong currency format") String from, @NotNull @Size(min = 3, max = 3, message = "wrong currency format") String to, @NotNull Double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public ConversionRequest() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversionRequest that = (ConversionRequest) o;
        return Objects.equals(from, that.from) &&
                Objects.equals(to, that.to) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, amount);
    }
}
