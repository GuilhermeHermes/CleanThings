package com.guilhermehermes.cleanthings.infra.factory;

import com.guilhermehermes.cleanthings.infra.repository.CouponRepository;
import com.guilhermehermes.cleanthings.infra.repository.ItemRepository;
import com.guilhermehermes.cleanthings.infra.repository.OrderRepository;
import com.guilhermehermes.cleanthings.infra.repository.UserRepository;

public interface RepositoryFactory {
    CouponRepository getCouponRepository();
    UserRepository getUserRepository();
    ItemRepository getItemRepository();
    OrderRepository getOrderRepository();
}
