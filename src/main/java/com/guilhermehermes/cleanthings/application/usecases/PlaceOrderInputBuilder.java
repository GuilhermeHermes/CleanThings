package com.guilhermehermes.cleanthings.application.usecases;

import com.guilhermehermes.cleanthings.domain.valueobjects.Cpf;
import com.guilhermehermes.cleanthings.domain.valueobjects.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderInputBuilder {
    private Cpf userCpf;
    private List<OrderItem> items = new ArrayList<>();
    private String cupom;


    PlaceOrderInputBuilder() {}

    public PlaceOrderInputBuilder withUserCpf(Cpf userCpf) {
        this.userCpf = userCpf;
        return this;
    }

    public PlaceOrderInputBuilder withItems(List<OrderItem> items) {
        this.items = items != null ? items : new ArrayList<>();
        return this;
    }

    public PlaceOrderInputBuilder withCupom(String cupom) {
        this.cupom = cupom;
        return this;
    }



    public PlaceOrderInput build() {
        return new PlaceOrderInput(this);
    }




    Cpf getUserCpf() {
        return userCpf;
    }

    List<OrderItem> getItems() {
        return items;
    }

    String getCupom() {
        return cupom;
    }


}
