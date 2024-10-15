package com.guilhermehermes.cleanthings.application.usecases.place_order;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guilhermehermes.cleanthings.domain.entities.Item;
import com.guilhermehermes.cleanthings.domain.valueobjects.Cpf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlaceOrderInput {
    private final Cpf userCpf;
    private final List<Item> items;
    private final String coupon;


    @JsonCreator
    public PlaceOrderInput(
            @JsonProperty("userCpf") Cpf userCpf,
            @JsonProperty("items") List<Item> items,
            @JsonProperty("coupon") String coupon) {
        this.userCpf = userCpf;
        this.items = Collections.unmodifiableList(new ArrayList<>(items));
        this.coupon = coupon;
    }

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

    public List<Item> getItems() {
        return items;
    }

    public String getCoupon() {
        return coupon;
    }


}


