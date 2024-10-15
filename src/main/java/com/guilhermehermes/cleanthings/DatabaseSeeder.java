package com.guilhermehermes.cleanthings;

import com.guilhermehermes.cleanthings.application.usecases.place_order.PlaceOrder;
import com.guilhermehermes.cleanthings.application.usecases.place_order.PlaceOrderInput;
import com.guilhermehermes.cleanthings.domain.entities.Coupon;
import com.guilhermehermes.cleanthings.domain.entities.Item;
import com.guilhermehermes.cleanthings.domain.entities.User;
import com.guilhermehermes.cleanthings.domain.valueobjects.Cpf;
import com.guilhermehermes.cleanthings.infra.factory.RepositoryFactory;
import com.guilhermehermes.cleanthings.infra.factory.RepositoryFactoryImpl;
import com.guilhermehermes.cleanthings.infra.repository.CouponRepository;
import com.guilhermehermes.cleanthings.infra.repository.ItemRepository;
import com.guilhermehermes.cleanthings.infra.repository.OrderRepository;
import com.guilhermehermes.cleanthings.infra.repository.UserRepository;
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



    public DatabaseSeeder(RepositoryFactory repositoryFactory) {
        this.orderRepository = repositoryFactory.getOrderRepository();
        this.itemRepository = repositoryFactory.getItemRepository();
        this.userRepository = repositoryFactory.getUserRepository();
        this.couponRepository = repositoryFactory.getCouponRepository();
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
        userRepository.saveAll(users);

        // Populando itens
        List<Item> items = new ArrayList<>();
        items.add(new Item("Notebook Dell", 3500.0, 30.0, 20.0, 5.0, 2.5));
        items.add(new Item("Monitor Samsung", 1200.0, 50.0, 40.0, 10.0, 5.0));
        items.add(new Item("Teclado Mecânico", 300.0, 15.0, 5.0, 2.0, 0.5));
        items.add(new Item("Mouse Logitech", 150.0, 10.0, 4.0, 3.0, 0.3));
        itemRepository.saveAll(items);

        Coupon coupon1 = new Coupon("BLACKFRIDAY", new BigDecimal("0.1"), new Date());
        Coupon coupon2 = new Coupon("CYBERMONDAY", new BigDecimal("0.2"), new Date());
        Coupon coupon3 = new Coupon("NATAL", new BigDecimal("0.3"), new Date());

        couponRepository.saveAll(List.of(
                new Coupon("BLACKFRIDAY", new BigDecimal("0.1"), new Date()),
                new Coupon("CYBERMONDAY", new BigDecimal("0.2"), new Date()),
                new Coupon("NATAL", new BigDecimal("0.3"), new Date())
        ));
        // Populando pedidos
        users.forEach(user -> {
            PlaceOrderInput input = PlaceOrderInput.builder()
                .withUserCpf(user.getCpf())
                .withItems(items)
                .withCupom(coupon1.getName())
                .build();

            PlaceOrder order = new PlaceOrder(new RepositoryFactoryImpl(couponRepository, userRepository, itemRepository, orderRepository));
            var output = order.execute(input);
            System.out.println(output.total);
            System.out.println(output.code);

        });



    }
}
