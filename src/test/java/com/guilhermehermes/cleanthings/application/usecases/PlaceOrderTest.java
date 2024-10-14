package com.guilhermehermes.cleanthings.application.usecases;

import com.guilhermehermes.cleanthings.repositories.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaceOrderTest {

    OrderRepository orderRepository;

    InMemoryUserRepository userRepository;

    ItemRepositoryInMemory itemRepository;

    CouponRepositoryInMemory couponRepository;


    @Test
    void shouldCreatePlaceOrder() {
        PlaceOrder placeOrder = new PlaceOrder(orderRepository, itemRepository, userRepository, couponRepository);
        assertNotNull(placeOrder);

    }

}