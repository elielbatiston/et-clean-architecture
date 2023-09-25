package com.encontrotecnico.controllers;

import com.encontrotecnico.repositories.models.ProdutoEntity;
import com.encontrotecnico.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProductController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid final ProdutoDTO produtoEntity) {
        service.save(ProdutoEntity.toDomain(produtoEntity));
    }

    @GetMapping("{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoEntity get(@PathVariable("uuid") final UUID uuid) {
        return service.find(uuid);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoEntity> getAll() {
        return service.findAll();
    }

    @DeleteMapping("{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("uuid") final UUID uuid) {
        service.delete(uuid);
    }
}
