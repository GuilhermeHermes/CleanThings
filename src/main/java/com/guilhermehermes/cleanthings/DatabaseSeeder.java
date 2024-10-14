package com.guilhermehermes.cleanthings;

import com.guilhermehermes.cleanthings.application.usecases.place_order.PlaceOrder;
import com.guilhermehermes.cleanthings.application.usecases.place_order.PlaceOrderInput;
import com.guilhermehermes.cleanthings.domain.entities.Coupon;
import com.guilhermehermes.cleanthings.domain.entities.Item;
import com.guilhermehermes.cleanthings.domain.entities.User;
import com.guilhermehermes.cleanthings.domain.valueobjects.Cpf;
import com.guilhermehermes.cleanthings.repositories.CouponRepository;
import com.guilhermehermes.cleanthings.repositories.ItemRepository;
import com.guilhermehermes.cleanthings.repositories.OrderRepository;
import com.guilhermehermes.cleanthings.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        users.add(new User("João Silva", "joao.silva@example.com", "senha123", new Cpf("642.826.170-71")));
        users.add(new User("Maria Oliveira", "maria.oliveira@example.com", "senha123", new Cpf("617.119.280-54")));
        users.add(new User("Carlos Souza", "carlos.souza@example.com", "senha123", new Cpf("860.297.500-70")));
        users.forEach(userRepository::save);

        // Populando itens
        List<Item> items = new ArrayList<>();
        items.add(new Item("Notebook Dell", 3500.0, 30.0, 20.0, 5.0, 2.5));
        items.add(new Item("Monitor Samsung", 1200.0, 50.0, 40.0, 10.0, 5.0));
        items.add(new Item("Teclado Mecânico", 300.0, 15.0, 5.0, 2.0, 0.5));
        items.add(new Item("Mouse Logitech", 150.0, 10.0, 4.0, 3.0, 0.3));
        items.forEach(itemRepository::save);

        Coupon coupon1 = new Coupon("BLACKFRIDAY", new BigDecimal(0.1), new Date());
        Coupon coupon2 = new Coupon("CYBERMONDAY", new BigDecimal(0.2), new Date());
        Coupon coupon3 = new Coupon("NATAL", new BigDecimal(0.3), new Date());

        couponRepository.saveAll(List.of(
                new Coupon("BLACKFRIDAY", new BigDecimal(0.1), new Date()),
                new Coupon("CYBERMONDAY", new BigDecimal(0.2), new Date()),
                new Coupon("NATAL", new BigDecimal(0.3), new Date())
        ));
        // Populando pedidos
        users.forEach(user -> {
            PlaceOrderInput input = PlaceOrderInput.builder()
                .withUserCpf(user.getCpf())
                .withItems(items)
                .withCupom(coupon1.getName())
                .build();

            PlaceOrder order = new PlaceOrder(orderRepository, itemRepository, userRepository, couponRepository);
            var output = order.execute(input);
            System.out.println(output.total);
            System.out.println(output.code);

        });



    }
}
