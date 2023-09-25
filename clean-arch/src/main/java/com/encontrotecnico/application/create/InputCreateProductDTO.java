package com.encontrotecnico.application.create;

import com.fasterxml.jackson.annotation.JsonProperty;

public record InputCreateProductDTO (
        @JsonProperty("nome")
        String name,
        @JsonProperty("preco")
        Double price
) { }
