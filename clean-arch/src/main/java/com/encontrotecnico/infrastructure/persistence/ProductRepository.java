package com.encontrotecnico.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ProductRepository extends MongoRepository<ProductModel, String> { }
