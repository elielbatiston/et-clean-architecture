package com.encontrotecnico.infrastructure.events;

import com.fasterxml.jackson.annotation.JsonProperty;

public record InputCreateProductEventDTO(
        @JsonProperty("n")
        String name,
        @JsonProperty("p")
        Double price
) { }
