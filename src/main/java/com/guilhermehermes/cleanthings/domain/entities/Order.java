package com.guilhermehermes.cleanthings.domain.entities;

import com.guilhermehermes.cleanthings.domain.valueobjects.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
public class Order extends BaseEntity{

    private Cpf userCpf;
    private List<OrderItem> items;
    private Coupon coupon;
    private double freight;
    private OrderCode code;

    private FreightCalculator freightCalculator;

    public Order(){
        super();
        this.freightCalculator = new DefaultFreightCalculator();
    }

    public Order(Cpf userCpf, FreightCalculator freightCalculator, Long sequentialNumber) {
        super();
        this.userCpf = userCpf;
        this.items = new ArrayList<>();
        this.freightCalculator = freightCalculator;
        this.code = OrderCode.createForCurrentYear(sequentialNumber);
    }

    public double getTotal(){
        return items.stream().mapToDouble(item -> item.getPriceItem() * item.getQuantity()).sum() + freight;
    }

    public double getTotalWithDiscount(){
        return getTotal() * (1 - coupon.getPercentage().doubleValue()) + freight;
    }

    public void addItem(Item item, Integer quantity){
        this.freight = freightCalculator.calculate(item) * quantity;
        items.add(new OrderItem(item.getId(), item.getPrice(), quantity));

    }

    public void addItems(List<OrderItem> items){
        this.items.addAll(items);
    }

    public void addCoupon(Coupon coupon){
        this.coupon = coupon;
    }



}
