package com.guilhermehermes.cleanthings.domain.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Coupon extends BaseEntity{

    private String name;
    private BigDecimal percentage;
    private Date expiredDate;

    public Coupon() {
        super();
    }

    public Coupon(String name, BigDecimal percentage, Date expiredDate) {
        super();
        this.name = name;
        this.percentage = percentage;
        this.expiredDate = expiredDate;
    }

    public boolean isValid() {
        return this.name != null && this.percentage != null && ! isExpired();
    }

    private boolean isExpired() {
        return this.expiredDate.after(new Date());

    }
}
