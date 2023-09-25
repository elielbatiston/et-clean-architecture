package com.encontrotecnico.services;

import com.encontrotecnico.repositories.ProdutoRepository;
import com.encontrotecnico.repositories.models.ProdutoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public void save(final ProdutoEntity produtoEntity) {
        repository.save(produtoEntity);
    }

    public ProdutoEntity find(final UUID uuid) {
        return repository.findById(uuid).orElse(new ProdutoEntity());
    }

    public List<ProdutoEntity> findAll() {
        return repository.findAll();
    }

    public void delete(final UUID uuid) {
        repository.deleteById(uuid);
    }
}
