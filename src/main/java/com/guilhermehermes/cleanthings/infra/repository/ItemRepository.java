package com.guilhermehermes.cleanthings.infra.repository;

import com.guilhermehermes.cleanthings.domain.entities.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, ObjectId> {
    boolean existsById(ObjectId id);

}
