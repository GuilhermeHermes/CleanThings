package com.guilhermehermes.cleanthings.application.usecases.get_orders;

import com.guilhermehermes.cleanthings.domain.entities.Order;
import com.guilhermehermes.cleanthings.infra.repository.OrderRepository;

import java.util.List;

public class GetOrders {

    private final OrderRepository orderRepository;

    public GetOrders(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> execute(String code) {
        List<Order> orders = orderRepository.findAll();
        if (orders.isEmpty()) {
            throw new RuntimeException("Orders not found");
        }
        return orders;
        }
}
