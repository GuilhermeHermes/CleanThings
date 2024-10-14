package com.guilhermehermes.cleanthings.repositories;

import com.guilhermehermes.cleanthings.domain.entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    public User findByCpf(String cpf);
}
