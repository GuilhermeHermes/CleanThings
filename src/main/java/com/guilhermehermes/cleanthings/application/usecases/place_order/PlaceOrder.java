package com.guilhermehermes.cleanthings.application.usecases.place_order;

import com.guilhermehermes.cleanthings.domain.entities.Coupon;
import com.guilhermehermes.cleanthings.domain.valueobjects.DefaultFreightCalculator;
import com.guilhermehermes.cleanthings.domain.entities.Order;
import com.guilhermehermes.cleanthings.infra.factory.RepositoryFactory;
import com.guilhermehermes.cleanthings.infra.repository.CouponRepository;
import com.guilhermehermes.cleanthings.infra.repository.ItemRepository;
import com.guilhermehermes.cleanthings.infra.repository.OrderRepository;
import com.guilhermehermes.cleanthings.infra.repository.UserRepository;

public class PlaceOrder {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final CouponRepository couponRepository;


    public PlaceOrder(RepositoryFactory repositoryFactory) {
      this.userRepository = repositoryFactory.getUserRepository();
        this.orderRepository = repositoryFactory.getOrderRepository();
        this.itemRepository = repositoryFactory.getItemRepository();
        this.couponRepository = repositoryFactory.getCouponRepository();

    }

    public PlaceOrderOutput execute(PlaceOrderInput input) {



        Long sequence = orderRepository.count() + 1;

        if (userRepository.findByCpf(input.getUserCpf()) == null) {
            throw new RuntimeException("User not found");
        }
        Order order = new Order(input.getUserCpf(), new DefaultFreightCalculator(), sequence);

        input.getItems().forEach(item -> {
            if (!itemRepository.existsById(item.getId())) {
                throw new RuntimeException("Item not found");
            }
        });
        order.addItem(input.getItems().get(0), 1);

        Coupon coupon = couponRepository.findByName(input.getCoupon());
        if (coupon.isValid()) {
           order.addCoupon(coupon);
        }

        PlaceOrderOutput output = new PlaceOrderOutput(order.getTotal(), order.getCode());
        orderRepository.save(order);
        return output;
    }
}
