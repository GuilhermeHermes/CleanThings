package com.guilhermehermes.cleanthings.application.usecases.validate_coupon;

import com.guilhermehermes.cleanthings.domain.entities.Coupon;
import com.guilhermehermes.cleanthings.infra.repository.CouponRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ValidateCouponTest {

    @Mock
    CouponRepository couponRepository;

    ValidateCoupon validateCoupon;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        validateCoupon = new ValidateCoupon(couponRepository);
    }

    @Test
    void shouldValidateCoupon() {
        when(couponRepository.findByName("coupon")).thenReturn(new Coupon("coupon", new BigDecimal(10.0), new Date()));
        assertTrue(validateCoupon.execute("coupon"));
    }

    @Test
    void shouldInvalidateWhenCouponIsNull() {
        when(couponRepository.findByName("coupon")).thenReturn(null);
        assertFalse(validateCoupon.execute("coupon"));
    }

}