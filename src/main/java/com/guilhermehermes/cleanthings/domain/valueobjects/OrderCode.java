package com.guilhermehermes.cleanthings.domain.valueobjects;

import java.time.Year;
import java.util.Objects;

public class OrderCode {
    private final String value;

    public OrderCode(String value) {
        this.value = value;
    }

    public static OrderCode create(int year, long sequentialNumber) {
        if (year < 1000 || year > 9999) {
            throw new IllegalArgumentException("Year must be a 4-digit number");
        }
        if (sequentialNumber < 1 || sequentialNumber > 99999999) {
            throw new IllegalArgumentException("Sequential number must be between 1 and 99999999");
        }
        String formattedCode = String.format("#%d%08d", year, sequentialNumber);
        return new OrderCode(formattedCode);
    }

    public static OrderCode createForCurrentYear(long sequentialNumber) {
        return create(Year.now().getValue(), sequentialNumber);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderCode orderCode = (OrderCode) o;
        return Objects.equals(value, orderCode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
