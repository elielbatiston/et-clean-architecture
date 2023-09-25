package com.encontrotecnico.infrastructure.persistence;

import com.encontrotecnico.domain.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Document(collection = "product")
public class ProductModel {

    @Id
    @Field("_id")
    private String uuid;

    private String name;
    private Double price;

    public ProductModel() {
    }

    public ProductModel(final String uuid, final String name, final Double price) {
        this.uuid = uuid;
        this.name = name;
        this.price = price;
    }

    public String getUuid() {
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
                UUID.fromString(uuid),
                name,
                price
        );
    }

    public static ProductModel fromDomain(Product product) {
        return new ProductModel(
                product.getUuid().toString(),
                product.getName(),
                product.getPrice()
        );
    }
}
