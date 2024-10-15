package com.guilhermehermes.cleanthings.infra.config;

import com.guilhermehermes.cleanthings.application.usecases.place_order.PlaceOrder;
import com.guilhermehermes.cleanthings.infra.factory.RepositoryFactory;
import com.guilhermehermes.cleanthings.infra.factory.RepositoryFactoryImpl;
import com.guilhermehermes.cleanthings.infra.repository.CouponRepository;
import com.guilhermehermes.cleanthings.infra.repository.ItemRepository;
import com.guilhermehermes.cleanthings.infra.repository.OrderRepository;
import com.guilhermehermes.cleanthings.infra.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.guilhermehermes.cleanthings.infra.repository")
public class ApplicationConfig {

    @Bean
    public RepositoryFactory repositoryFactory(
            UserRepository userRepository,
            ItemRepository itemRepository,
            OrderRepository orderRepository,
            CouponRepository couponRepository) {
        return new RepositoryFactoryImpl(
                couponRepository,
                userRepository,
                itemRepository,
                orderRepository
                );
    }

    @Bean
    public PlaceOrder placeOrderUseCase(RepositoryFactory repositoryFactory) {
        return new PlaceOrder(repositoryFactory);
    }
}