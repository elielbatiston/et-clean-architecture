package com.encontrotecnico.application.find;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record OutputFindProductDTO(
        UUID uuid,
        @JsonProperty("nome")
        String name,
        @JsonProperty("preco")
        Double price
) {
}
