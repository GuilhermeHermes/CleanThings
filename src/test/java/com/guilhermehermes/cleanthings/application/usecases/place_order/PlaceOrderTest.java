package com.guilhermehermes.cleanthings.application.usecases.place_order;

import com.guilhermehermes.cleanthings.infra.factory.RepositoryFactoryImpl;
import com.guilhermehermes.cleanthings.infra.repository.CouponRepositoryInMemory;
import com.guilhermehermes.cleanthings.infra.repository.ItemRepositoryInMemory;
import com.guilhermehermes.cleanthings.infra.repository.OrderRepositoryInMemory;
import com.guilhermehermes.cleanthings.infra.repository.UserRepositoryInMemory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PlaceOrderTest {

    @Mock
    RepositoryFactoryImpl repositoryFactory;

    private PlaceOrder PlaceOrder;

    private PlaceOrderInput input;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        PlaceOrder = new PlaceOrder(repositoryFactory);
        input = new PlaceOrderInput(new PlaceOrderInputBuilder());
    }

    @Test
    void shouldCreatePlaceOrder() {

        when(repositoryFactory.getCouponRepository()).thenReturn(new CouponRepositoryInMemory());
        when(repositoryFactory.getUserRepository()).thenReturn(new UserRepositoryInMemory());
        when(repositoryFactory.getItemRepository()).thenReturn(new ItemRepositoryInMemory());
        when(repositoryFactory.getOrderRepository()).thenReturn(new OrderRepositoryInMemory());
        PlaceOrder placeOrder = new PlaceOrder(repositoryFactory);
        assertNotNull(placeOrder);

    }

}