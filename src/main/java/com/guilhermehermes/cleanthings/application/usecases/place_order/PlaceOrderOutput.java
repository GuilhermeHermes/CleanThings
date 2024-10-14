package com.guilhermehermes.cleanthings.application.usecases.place_order;

import com.guilhermehermes.cleanthings.domain.valueobjects.OrderCode;

public class PlaceOrderOutput {
    public Double total;
    public OrderCode code;

    public PlaceOrderOutput(Double total, OrderCode code) {
        this.total = total;
        this.code = code;


    }


}
