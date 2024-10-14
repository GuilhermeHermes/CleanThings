package com.guilhermehermes.cleanthings;

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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CleanThingsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CleanThingsApplication.class, args);
    }

}



