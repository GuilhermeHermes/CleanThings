package com.guilhermehermes.cleanthings.application.usecases.find_order_by_code;

import com.guilhermehermes.cleanthings.domain.entities.Order;
import com.guilhermehermes.cleanthings.infra.repository.OrderRepository;

public class FindOrderByCode {
    private final OrderRepository orderRepository;

    public FindOrderByCode(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order execute(String code) {
        Order order = orderRepository.findByCode(code);
        if (order == null) {
            throw new RuntimeException("Order not found");
        }
        return order;
    }
}
