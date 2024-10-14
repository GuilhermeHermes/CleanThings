package com.guilhermehermes.cleanthings.domain.entities;

import com.guilhermehermes.cleanthings.domain.valueobjects.Cpf;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
public class User extends BaseEntity {

    @NotBlank(message = "Nome não pode ser vazio")
    private String name;


    @NotBlank(message = "Email não pode ser vazio")
    @Email(message = "Email deve ser válido")
    private String email;

    @NotBlank(message = "Senha não pode ser vazia")
    @Size(min = 8, message = "Senha deve ter pelo menos 8 caracteres")
    private String password;

    @NotBlank(message = "CPF não pode ser vazio")
    private Cpf cpf;

    public User() {
        super();
    }

    public User(String name, String email, String password, Cpf cpf) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
    }






}
