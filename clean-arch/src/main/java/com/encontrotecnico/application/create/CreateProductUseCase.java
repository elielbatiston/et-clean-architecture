package com.encontrotecnico.application.create;

import com.encontrotecnico.domain.Product;
import com.encontrotecnico.domain.ProductGateway;

import java.util.Objects;

public class CreateProductUseCase {

    private final ProductGateway gateway;

    public CreateProductUseCase(final ProductGateway gateway) {
        this.gateway = Objects.requireNonNull(gateway);
    }

    public OutputCreateProductDTO execute(final InputCreateProductDTO input) {
        final var product = new Product(
                null,
                input.name(),
                input.price()
        );
        final var out = gateway.save(product);

        return new OutputCreateProductDTO(
                out.getUuid(),
                out.getName(),
                out.getPrice()
        );
    }
}
