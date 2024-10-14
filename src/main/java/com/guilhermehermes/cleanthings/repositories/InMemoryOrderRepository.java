package com.guilhermehermes.cleanthings.repositories;

import com.guilhermehermes.cleanthings.domain.entities.Order;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class InMemoryOrderRepository implements OrderRepository {
    private final Map<ObjectId, Order> database = new ConcurrentHashMap<>();


    @Override
    public <S extends Order> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends Order> List<S> insert(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public <S extends Order> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Order> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Order> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Order> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Order> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Order, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Order> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Order> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Order> findById(ObjectId objectId) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(ObjectId objectId) {
        return false;
    }

    @Override
    public List<Order> findAll() {
        return List.of();
    }

    @Override
    public List<Order> findAllById(Iterable<ObjectId> objectIds) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(ObjectId objectId) {

    }

    @Override
    public void delete(Order entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends ObjectId> objectIds) {

    }

    @Override
    public void deleteAll(Iterable<? extends Order> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Order> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return null;
    }
}
