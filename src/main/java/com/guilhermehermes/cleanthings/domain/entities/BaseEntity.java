package com.guilhermehermes.cleanthings.domain.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public abstract class BaseEntity {
    @Id
    private ObjectId id;
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    private boolean active = true;

    public BaseEntity() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }
}
