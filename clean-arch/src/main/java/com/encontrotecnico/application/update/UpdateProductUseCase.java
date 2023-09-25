package com.encontrotecnico.application.update;

import com.encontrotecnico.domain.Product;
import com.encontrotecnico.domain.ProductGateway;

import java.util.Objects;

public class UpdateProductUseCase {

    private final ProductGateway gateway;

    public UpdateProductUseCase(final ProductGateway gateway) {
        this.gateway = Objects.requireNonNull(gateway);
    }

    public OutputUpdateProductDTO execute(final InputUpdateProductDTO input) {
        final var currentProduct = gateway.find(input.uuid());
        final var product = new Product(
                currentProduct.getUuid(),
                input.name(),
                input.price()
        );
        final var out = gateway.save(product);

        return new OutputUpdateProductDTO(
                out.getUuid(),
                out.getName(),
                out.getPrice()
        );
    }
}
