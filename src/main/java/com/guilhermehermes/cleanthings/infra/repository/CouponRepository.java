package com.guilhermehermes.cleanthings.infra.repository;

import com.guilhermehermes.cleanthings.domain.entities.Coupon;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CouponRepository extends MongoRepository<Coupon, String> {
    boolean existsByName(String name);

    Coupon findByName(String coupon);
}
