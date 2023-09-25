package com.encontrotecnico.domain;

import java.util.List;
import java.util.UUID;

public interface ProductGateway {

    Product save(final Product product);

    Product find(final UUID uuid);

    List<Product> findAll();

    void delete(final UUID uuid);
}
