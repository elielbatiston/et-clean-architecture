package com.encontrotecnico.infrastructure;

import com.encontrotecnico.domain.Product;
import com.encontrotecnico.domain.ProductGateway;
import com.encontrotecnico.domain.exceptions.ObjectNotFoundException;
import com.encontrotecnico.infrastructure.persistence.ProductModel;
import com.encontrotecnico.infrastructure.persistence.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
public class ProductPostgreGateway implements ProductGateway {

    private final ProductRepository repository;

    public ProductPostgreGateway(final ProductRepository repository) {
        this.repository = Objects.requireNonNull(repository);
    }

    @Override
    public Product save(final Product product) {
        final var model = repository.save(ProductModel.fromDomain(product));
        return model.toDomain();
    }

    @Override
    public Product find(final UUID uuid) {
        final var model = repository.findById(uuid)
                .orElseThrow(() -> new ObjectNotFoundException(String.format("Object %s not found", uuid.toString())));
        return model.toDomain();
    }

    @Override
    public List<Product> findAll() {
        final var model = repository.findAll();
        return model.stream()
                .map(it -> it.toDomain())
                .toList();
    }

    @Override
    public void delete(final UUID uuid) {
        repository.deleteById(uuid);
    }
}
