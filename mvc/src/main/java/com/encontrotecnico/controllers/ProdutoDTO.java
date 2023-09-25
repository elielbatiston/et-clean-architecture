package com.encontrotecnico.controllers;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public class ProdutoDTO {

    @NotBlank(message = "O nome não pode ser vazio")
    private String name;

    @DecimalMin(value = "1.0", message = "O valor deve ser maior que 1")
    private Double price;

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
}
