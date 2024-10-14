package com.guilhermehermes.cleanthings.domain.entities;

import com.guilhermehermes.cleanthings.domain.valueobjects.Cpf;
import com.guilhermehermes.cleanthings.domain.valueobjects.DefaultFreightCalculator;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void shouldCreateOrderWith3Items() {
        Order order = new Order(new Cpf("05393332394"), new DefaultFreightCalculator(), 1L);

        Item item = new Item("Item 1", 10.0, 10.0, 10.0, 10.0, 10.0);
        Item item2 = new Item("Item 2", 20.0, 20.0, 20.0, 20.0, 20.0);
        Item item3 = new Item("Item 3", 30.0, 30.0, 30.0, 30.0, 30.0);
        item.setId(new ObjectId("123456789123456789123412"));
        item2.setId(new ObjectId("123456789123456789123413"));
        item3.setId(new ObjectId("123456789123456789123414"));


           order.addItem(item, 1);
        order.addItem(item2, 1);
        order.addItem(item3, 2);
        assertEquals(3, order.getItems().size());
    }

    @Test
    void addItem() {
        Order order = new Order(new Cpf("05393332394"), new DefaultFreightCalculator(), 1L);

        Item item = new Item("guitarra", 10.0, 10.0, 10.0, 10.0, 10.0);
        order.addItem(item, 2);
        assertEquals(1, order.getItems().size());
    }

    @Test
    void getTotal() {
        Order order = new Order(new Cpf("05393332394"), new DefaultFreightCalculator(), 1L);
        Item item = new Item("guitarra", 10.0, 10.0, 10.0, 10.0, 10.0);
        order.addItem(item, 2);
        assertEquals(220.0, order.getTotal());
    }

}