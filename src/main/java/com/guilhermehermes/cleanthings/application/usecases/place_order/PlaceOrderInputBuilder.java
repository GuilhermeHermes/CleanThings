package com.guilhermehermes.cleanthings.application.usecases.place_order;

import com.guilhermehermes.cleanthings.domain.entities.Item;
import com.guilhermehermes.cleanthings.domain.valueobjects.Cpf;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderInputBuilder {
    private Cpf userCpf;
    private List<Item> items = new ArrayList<>();
    private String cupom;


    PlaceOrderInputBuilder() {}

    public PlaceOrderInputBuilder withUserCpf(Cpf userCpf) {
        this.userCpf = userCpf;
        return this;
    }

    public PlaceOrderInputBuilder withItems(List<Item> items) {
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

    List<Item> getItems() {
        return items;
    }

    String getCupom() {
        return cupom;
    }


}
