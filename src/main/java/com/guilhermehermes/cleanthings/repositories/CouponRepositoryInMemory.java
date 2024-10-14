package com.guilhermehermes.cleanthings.repositories;

import com.guilhermehermes.cleanthings.domain.entities.Coupon;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class CouponRepositoryInMemory implements CouponRepository{

    @Override
    public boolean existsByName(String name) {
        return false;
    }

    public Coupon findByName(String coupon) {
        return null;
    }

    @Override
    public <S extends Coupon> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends Coupon> List<S> insert(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public <S extends Coupon> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Coupon> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Coupon> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Coupon> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Coupon> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Coupon> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Coupon, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Coupon> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Coupon> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Coupon> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<Coupon> findAll() {
        return List.of();
    }

    @Override
    public List<Coupon> findAllById(Iterable<String> strings) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Coupon entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Coupon> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Coupon> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Coupon> findAll(Pageable pageable) {
        return null;
    }
}
