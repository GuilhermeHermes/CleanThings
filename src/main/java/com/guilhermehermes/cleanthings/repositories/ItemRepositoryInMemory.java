package com.guilhermehermes.cleanthings.repositories;


import com.guilhermehermes.cleanthings.domain.entities.Item;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ItemRepositoryInMemory implements ItemRepository{
    private List<Item> items = new ArrayList<>();

    public ItemRepositoryInMemory() {
        // Instanciando alguns itens
        items.add(new Item("Laptop", 1500.0, 35.0, 25.0, 2.0, 1.5));
        items.add(new Item("Smartphone", 800.0, 15.0, 7.0, 0.8, 0.2));
        items.add(new Item("Tablet", 600.0, 25.0, 18.0, 1.0, 0.5));
    }

    @Override
    public <S extends Item> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    public List<Item> findAll() {
        return new ArrayList<>(items);
    }

    @Override
    public List<Item> findAllById(Iterable<ObjectId> objectIds) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    public Optional<Item> findById(ObjectId id) {
        return items.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    public Item save(Item item) {
        items.add(item);
        return item;
    }

    public void deleteById(ObjectId id) {
        items.removeIf(item -> item.getId().equals(id));
    }

    @Override
    public void delete(Item entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends ObjectId> objectIds) {

    }

    @Override
    public void deleteAll(Iterable<? extends Item> entities) {

    }

    @Override
    public void deleteAll() {

    }

    public boolean exists(ObjectId id) {
        return items.stream().anyMatch(item -> item.getId().equals(id));
    }

    @Override
    public boolean existsById(ObjectId id) {
        return false;
    }



    @Override
    public <S extends Item> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends Item> List<S> insert(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public <S extends Item> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Item> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Item> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Item> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Item> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Item> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Item, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Item> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Item> findAll(Pageable pageable) {
        return null;
    }
}
