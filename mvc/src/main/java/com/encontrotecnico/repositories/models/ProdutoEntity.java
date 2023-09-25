package com.encontrotecnico.repositories.models;

import com.encontrotecnico.controllers.ProdutoDTO;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @Column
    private String name;

    @Column
    private Double price;

    public ProdutoEntity() {

    }

    public ProdutoEntity(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static ProdutoEntity toDomain(ProdutoDTO dto) {
        return new ProdutoEntity(
                dto.getName(),
                dto.getPrice()
        );
    }
}
