package com.guilhermehermes.cleanthings.repositories;

import com.guilhermehermes.cleanthings.domain.entities.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface OrderRepository extends MongoRepository<Order, ObjectId> {
}
