package com.encontrotecnico.infrastructure.persistence;

import com.encontrotecnico.domain.Product;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "product")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    private String name;
    private Double price;

    public ProductModel() {
    }

    public ProductModel(final UUID uuid, final String name, final Double price) {
        this.uuid = uuid;
        this.name = name;
        this.price = price;
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

    public Product toDomain() {
        return new Product(
                uuid,
                name,
                price
        );
    }

    public static ProductModel fromDomain(Product product) {
        return new ProductModel(
                product.getUuid(),
                product.getName(),
                product.getPrice()
        );
    }
}
