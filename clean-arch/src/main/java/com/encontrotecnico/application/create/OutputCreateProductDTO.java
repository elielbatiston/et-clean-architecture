package com.encontrotecnico.application.create;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record OutputCreateProductDTO(
        UUID uuid,
        @JsonProperty("nome")
        String name,
        @JsonProperty("preco")
        Double price
) { }
