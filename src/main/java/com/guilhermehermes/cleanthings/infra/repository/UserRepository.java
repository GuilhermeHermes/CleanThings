package com.guilhermehermes.cleanthings.infra.repository;

import com.guilhermehermes.cleanthings.domain.entities.User;
import com.guilhermehermes.cleanthings.domain.valueobjects.Cpf;
import jakarta.validation.constraints.NotBlank;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    public User findByCpf(@NotBlank(message = "CPF não pode ser vazio") Cpf cpf);
}
