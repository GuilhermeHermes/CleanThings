package com.guilhermehermes.cleanthings.domain.valueobjects;

import com.guilhermehermes.cleanthings.domain.entities.Item;

public class CustomFreightCalculator implements FreightCalculator {

    public Double calculate(Item item) {
      return 0.0;
    }
}
