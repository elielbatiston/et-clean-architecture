package com.encontrotecnico.domain;

import com.encontrotecnico.domain.exceptions.DomainException;

import java.util.UUID;

public class Product {

    private UUID uuid;
    private String name;
    private Double price;

    public Product(final UUID uuid, final String name, final Double price) {
        this.uuid = uuid;
        this.name = name;
        this.price = price;
        this.validate();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    private void validate() {
        if (this.name == null || this.name.trim().isEmpty()) {
            throw new DomainException("O nome não pode ser em branco");
        }

        if (this.price < 1.0) {
            throw new DomainException("O preço não pode ser menor que 1.0");
        }
    }
}
