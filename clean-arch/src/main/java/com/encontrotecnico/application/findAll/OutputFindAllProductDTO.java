package com.encontrotecnico.application.findAll;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record OutputFindAllProductDTO(
        UUID uuid,
        @JsonProperty("nome")
        String name,
        @JsonProperty("preco")
        Double price
) { }
