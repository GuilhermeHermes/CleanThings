package com.guilhermehermes.cleanthings.infra.factory;


import com.guilhermehermes.cleanthings.infra.repository.CouponRepository;
import com.guilhermehermes.cleanthings.infra.repository.ItemRepository;
import com.guilhermehermes.cleanthings.infra.repository.OrderRepository;
import com.guilhermehermes.cleanthings.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryFactoryImpl implements RepositoryFactory {
        private final CouponRepository couponRepository;
        private final UserRepository userRepository;
        private final ItemRepository itemRepository;
        private final OrderRepository orderRepository;

        @Autowired
        public RepositoryFactoryImpl(CouponRepository couponRepository,
                                     UserRepository userRepository,
                                     ItemRepository itemRepository,
                                     OrderRepository orderRepository) {
            this.couponRepository = couponRepository;
            this.userRepository = userRepository;
            this.itemRepository = itemRepository;
            this.orderRepository = orderRepository;
        }

        public CouponRepository getCouponRepository() {
            return couponRepository;
        }

        public UserRepository getUserRepository() {
            return userRepository;
        }

        public ItemRepository getItemRepository() {
            return itemRepository;
        }

        public OrderRepository getOrderRepository() {
            return orderRepository;
        }
    }

