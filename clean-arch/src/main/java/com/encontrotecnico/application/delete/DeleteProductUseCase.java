package com.encontrotecnico.application.delete;

import com.encontrotecnico.domain.ProductGateway;

import java.util.Objects;

public class DeleteProductUseCase {

    private final ProductGateway gateway;

    public DeleteProductUseCase(final ProductGateway gateway) {
        this.gateway = Objects.requireNonNull(gateway);
    }

    public void execute(final InputDeleteProductDTO input) {
        gateway.delete(input.uuid());
    }
}
