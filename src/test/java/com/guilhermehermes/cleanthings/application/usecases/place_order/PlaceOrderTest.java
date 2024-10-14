package com.guilhermehermes.cleanthings.application.usecases.place_order;

import com.guilhermehermes.cleanthings.repositories.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaceOrderTest {

    OrderRepository orderRepository;

    UserRepositoryInMemory userRepository;

    ItemRepositoryInMemory itemRepository;

    CouponRepositoryInMemory couponRepository;


    @Test
    void shouldCreatePlaceOrder() {

        PlaceOrder placeOrder = new PlaceOrder(orderRepository, itemRepository, userRepository, couponRepository);
        assertNotNull(placeOrder);

    }

}