package com.guilhermehermes.cleanthings.application.usecases;

import com.guilhermehermes.cleanthings.domain.entities.Coupon;
import com.guilhermehermes.cleanthings.domain.valueobjects.DefaultFreightCalculator;
import com.guilhermehermes.cleanthings.domain.entities.Order;
import com.guilhermehermes.cleanthings.repositories.CouponRepository;
import com.guilhermehermes.cleanthings.repositories.ItemRepository;
import com.guilhermehermes.cleanthings.repositories.OrderRepository;
import com.guilhermehermes.cleanthings.repositories.UserRepository;

public class PlaceOrder {

    ItemRepository itemRepository;
    UserRepository userRepository;
    CouponRepository couponRepository;
    OrderRepository orderRepository;

    public PlaceOrder(OrderRepository orderRepository, ItemRepository itemRepository, UserRepository userRepository, CouponRepository couponRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.couponRepository = couponRepository;
    }

    public PlaceOrderOutput execute(PlaceOrderInput input) {
        Long sequence = orderRepository.count() + 1;

        if (userRepository.findByCpf(input.getUserCpf().toString()) == null) {
            throw new RuntimeException("User not found");
        }
        Order order = new Order(input.getUserCpf(), new DefaultFreightCalculator(), sequence);

        input.getItems().forEach(item -> {
            if (!itemRepository.existsById(item.getIdItem())) {
                throw new RuntimeException("Item not found");
            }
        });
        order.addItems(input.getItems());

        Coupon coupon = couponRepository.findByName(input.getCoupon());
        if (coupon.isValid()) {
           order.addCoupon(coupon);
        }

        PlaceOrderOutput output = new PlaceOrderOutput(order.getTotal());
        orderRepository.save(order);
        return output;
    }
}
