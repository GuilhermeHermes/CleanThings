package com.guilhermehermes.cleanthings.domain.valueobjects;

import com.guilhermehermes.cleanthings.domain.entities.Item;

public class DefaultFreightCalculator implements FreightCalculator {

    public Double calculate(Item item) {
        var freightValue = (1000 * item.getVolume() * item.getDensity()/100);
        var minFreightValue = 10;
        return Math.max(minFreightValue,  freightValue);
    }
}
