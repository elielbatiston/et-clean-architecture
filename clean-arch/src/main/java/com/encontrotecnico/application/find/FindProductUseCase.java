package com.encontrotecnico.application.find;

import com.encontrotecnico.domain.ProductGateway;

import java.util.Objects;

public class FindProductUseCase {

    private final ProductGateway gateway;

    public FindProductUseCase(ProductGateway gateway) {
        this.gateway = Objects.requireNonNull(gateway);
    }

    public OutputFindProductDTO execute(final InputFindProductDTO input) {
        final var output = gateway.find(input.uuid());
        return new OutputFindProductDTO(
                output.getUuid(),
                output.getName(),
                output.getPrice()
        );
    }
}
