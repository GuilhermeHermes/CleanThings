package com.guilhermehermes.cleanthings;

import com.guilhermehermes.cleanthings.domain.entities.Coupon;
import com.guilhermehermes.cleanthings.domain.entities.Item;
import com.guilhermehermes.cleanthings.domain.entities.Order;
import com.guilhermehermes.cleanthings.domain.entities.User;
import com.guilhermehermes.cleanthings.domain.valueobjects.Cpf;
import com.guilhermehermes.cleanthings.domain.valueobjects.DefaultFreightCalculator;
import com.guilhermehermes.cleanthings.domain.valueobjects.FreightCalculator;
import com.guilhermehermes.cleanthings.repositories.CouponRepository;
import com.guilhermehermes.cleanthings.repositories.ItemRepository;
import com.guilhermehermes.cleanthings.repositories.OrderRepository;
import com.guilhermehermes.cleanthings.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class DatabaseSeeder {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final CouponRepository couponRepository;



    public DatabaseSeeder(OrderRepository orderRepository, ItemRepository itemRepository, UserRepository userRepository, CouponRepository couponRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.couponRepository = couponRepository;
    }

    @Bean
    public CommandLineRunner initDatabase() {
        return args -> {
            populateDatabase();
        };
    }

    private void populateDatabase() {
        userRepository.deleteAll();
        itemRepository.deleteAll();
        orderRepository.deleteAll();
        couponRepository.deleteAll();

        // Populando usuários
        List<User> users = new ArrayList<>();
        users.add(new User("João Silva", "joao.silva@example.com", "senha123", new Cpf("05393332394")));
        users.add(new User("Maria Oliveira", "maria.oliveira@example.com", "senha123", new Cpf("05393332394")));
        users.add(new User("Carlos Souza", "carlos.souza@example.com", "senha123", new Cpf("05393332394")));
        users.forEach(userRepository::save);

        // Populando itens
        List<Item> items = new ArrayList<>();
        items.add(new Item("Notebook Dell", 3500.0, 30.0, 20.0, 5.0, 2.5));
        items.add(new Item("Monitor Samsung", 1200.0, 50.0, 40.0, 10.0, 5.0));
        items.add(new Item("Teclado Mecânico", 300.0, 15.0, 5.0, 2.0, 0.5));
        items.add(new Item("Mouse Logitech", 150.0, 10.0, 4.0, 3.0, 0.3));
        items.forEach(itemRepository::save);

        // Populando pedidos
        users.forEach(user -> {
            FreightCalculator freightCalculator = new DefaultFreightCalculator();
            Order order = new Order(user.getCpf(), freightCalculator, 1L);

            // Adicionando itens ao pedido
            order.addItem(items.get(0), 1); // Notebook
            order.addItem(items.get(1), 2); // Monitor
            order.addItem(items.get(2), 1); // Teclado

            // Salvando pedido
            orderRepository.save(order);
        });

        new Coupon("BLACKFRIDAY", new BigDecimal(0.1), new Date());
        new Coupon("CYBERMONDAY", new BigDecimal(0.2), new Date());
        new Coupon("NATAL", new BigDecimal(0.3), new Date());
        couponRepository.saveAll(List.of(
            new Coupon("BLACKFRIDAY", new BigDecimal(0.1), new Date()),
            new Coupon("CYBERMONDAY", new BigDecimal(0.2), new Date()),
            new Coupon("NATAL", new BigDecimal(0.3), new Date())
        ));

    }
}
