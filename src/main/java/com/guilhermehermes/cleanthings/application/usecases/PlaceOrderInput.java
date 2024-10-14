package com.guilhermehermes.cleanthings.application.usecases;

import com.guilhermehermes.cleanthings.domain.valueobjects.Cpf;
import com.guilhermehermes.cleanthings.domain.valueobjects.OrderItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlaceOrderInput {
    private final Cpf userCpf;
    private final List<OrderItem> items;
    private final String coupon;

    // Construtor package-private
    PlaceOrderInput(PlaceOrderInputBuilder builder) {
        this.userCpf = builder.getUserCpf();
        this.items = Collections.unmodifiableList(new ArrayList<>(builder.getItems()));
        this.coupon = builder.getCupom();
    }

    public static PlaceOrderInputBuilder builder() {
        return new PlaceOrderInputBuilder();
    }

    public Cpf getUserCpf() {
        return userCpf;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public String getCoupon() {
        return coupon;
    }


}


