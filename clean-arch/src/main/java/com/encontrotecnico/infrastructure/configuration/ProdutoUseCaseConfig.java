package com.encontrotecnico.infrastructure.configuration;

import com.encontrotecnico.application.create.CreateProductUseCase;
import com.encontrotecnico.application.delete.DeleteProductUseCase;
import com.encontrotecnico.application.find.FindProductUseCase;
import com.encontrotecnico.application.findAll.FindAllProductUseCase;
import com.encontrotecnico.application.update.UpdateProductUseCase;
import com.encontrotecnico.domain.ProductGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class ProdutoUseCaseConfig {

    private final ProductGateway gateway;

    public ProdutoUseCaseConfig(final ProductGateway gateway) {
        this.gateway = Objects.requireNonNull(gateway);
    }

    @Bean
    public CreateProductUseCase createProductUseCase() {
        return new CreateProductUseCase(gateway);
    }

    @Bean
    public UpdateProductUseCase updateProductUseCase() {
        return new UpdateProductUseCase(gateway);
    }

    @Bean
    public FindProductUseCase findProductUseCase() {
        return new FindProductUseCase(gateway);
    }

    @Bean
    public FindAllProductUseCase findAllProductUseCase() {
        return new FindAllProductUseCase(gateway);
    }

    @Bean
    public DeleteProductUseCase deleteProductUseCase() {
        return new DeleteProductUseCase(gateway);
    }
}
