package com.guilhermehermes.cleanthings.application.usecases.validate_coupon;

import com.guilhermehermes.cleanthings.domain.entities.Coupon;
import com.guilhermehermes.cleanthings.infra.repository.CouponRepository;

public class ValidateCoupon {

    private CouponRepository couponRepository;

    public ValidateCoupon(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public boolean execute(String couponName) {
      Coupon coupon = couponRepository.findByName(couponName);
      if(coupon == null) {
        return false;
      }
      return coupon.isValid();
    }
}
