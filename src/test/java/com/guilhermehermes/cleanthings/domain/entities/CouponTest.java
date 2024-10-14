package com.guilhermehermes.cleanthings.domain.entities;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CouponTest {

    @Test
    void shouldCreateValidCoupon() {
        Coupon coupon = new Coupon("VALE20", new BigDecimal(20.0), new Date());
        assertNotNull(coupon);
    }

    @Test
    void shouldCreateInvalidCoupon() {
        Coupon coupon = new Coupon("VALE20", new BigDecimal(20.0), new Date(2020, 1, 1));
        assertFalse(coupon.isValid());
    }

}