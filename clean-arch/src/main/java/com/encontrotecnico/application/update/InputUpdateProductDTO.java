package com.encontrotecnico.application.update;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record InputUpdateProductDTO (
        UUID uuid,
        @JsonProperty("nome")
        String name,
        @JsonProperty("preco")
        Double price
){ }