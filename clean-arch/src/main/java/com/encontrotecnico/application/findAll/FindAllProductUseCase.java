package com.encontrotecnico.application.findAll;

import com.encontrotecnico.domain.ProductGateway;

import java.util.List;
import java.util.Objects;

public class FindAllProductUseCase {

    private final ProductGateway gateway;

    public FindAllProductUseCase(final ProductGateway gateway) {
        this.gateway = Objects.requireNonNull(gateway);
    }

    public List<OutputFindAllProductDTO> execute() {
        final var outputs = gateway.findAll();
        return outputs.stream()
                .map(it -> new OutputFindAllProductDTO(
                        it.getUuid(),
                        it.getName(),
                        it.getPrice()
                ))
                .toList();
    }
}
