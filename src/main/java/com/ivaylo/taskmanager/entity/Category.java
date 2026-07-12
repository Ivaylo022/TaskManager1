package com.ivaylo.taskmanager.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import java.util.UUID;

   @Entity
   @Table(name = "categories")
    public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

       @NotBlank
       @Size(min = 2, max = 30)
       private String name;

    public Category() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

