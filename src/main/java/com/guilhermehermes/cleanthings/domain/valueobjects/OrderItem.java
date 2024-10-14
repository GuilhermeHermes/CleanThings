package com.guilhermehermes.cleanthings.domain.valueobjects;

import lombok.*;
import org.bson.types.ObjectId;


@Data
public class OrderItem {

    ObjectId idItem;
    Double priceItem;
    Integer quantity;

    public OrderItem() {
        super();
    }

    public OrderItem(ObjectId idItem, Double priceItem, Integer quantity) {
        this.idItem = idItem;
        this.priceItem = priceItem;
        this.quantity = quantity;
    }



}
