package com.encontrotecnico.application.update;

import java.util.UUID;

public class OutputUpdateProductDTO {

    private UUID uuid;
    private String name;
    private Double price;

    public OutputUpdateProductDTO(final UUID uuid, final String name, final Double price) {
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
}
