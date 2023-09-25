package com.encontrotecnico.infrastructure.restapi;

import com.encontrotecnico.application.create.CreateProductUseCase;
import com.encontrotecnico.application.create.InputCreateProductDTO;
import com.encontrotecnico.application.create.OutputCreateProductDTO;
import com.encontrotecnico.application.delete.DeleteProductUseCase;
import com.encontrotecnico.application.delete.InputDeleteProductDTO;
import com.encontrotecnico.application.find.FindProductUseCase;
import com.encontrotecnico.application.find.InputFindProductDTO;
import com.encontrotecnico.application.find.OutputFindProductDTO;
import com.encontrotecnico.application.findAll.FindAllProductUseCase;
import com.encontrotecnico.application.findAll.OutputFindAllProductDTO;
import com.encontrotecnico.application.update.InputUpdateProductDTO;
import com.encontrotecnico.application.update.OutputUpdateProductDTO;
import com.encontrotecnico.application.update.UpdateProductUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final FindProductUseCase findProductUseCase;
    private final FindAllProductUseCase findAllProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    public ProductController(
            final CreateProductUseCase createProductUseCase,
            final UpdateProductUseCase updateProductUseCase,
            final FindProductUseCase findProductUseCase,
            final FindAllProductUseCase findAllProductUseCase,
            final DeleteProductUseCase deleteProductUseCase
    ) {
        this.createProductUseCase = Objects.requireNonNull(createProductUseCase);
        this.updateProductUseCase = Objects.requireNonNull(updateProductUseCase);
        this.findProductUseCase = Objects.requireNonNull(findProductUseCase);
        this.findAllProductUseCase = Objects.requireNonNull(findAllProductUseCase);
        this.deleteProductUseCase = Objects.requireNonNull(deleteProductUseCase);
    }

    @PostMapping
    public ResponseEntity<OutputCreateProductDTO> create(@RequestBody final InputCreateProductDTO input) {
        final var output = createProductUseCase.execute(input);
        final var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(output.uuid()).toUri();

        return ResponseEntity.created(uri).body(output);
    }

    @PutMapping("{uuid}")
    public ResponseEntity<OutputUpdateProductDTO> update(
            @PathVariable("uuid") UUID uuid,
            @RequestBody final InputUpdateProductDTO input
    ) {
        final var output = updateProductUseCase.execute(input);
        return ResponseEntity.ok().body(output);
    }

    @GetMapping("{uuid}")
    public ResponseEntity<OutputFindProductDTO> find(@PathVariable("uuid") final UUID uuid) {
        final var input = new InputFindProductDTO(
                uuid
        );
        final var output = findProductUseCase.execute(input);
        return ResponseEntity.ok().body(output);
    }

    @GetMapping
    public ResponseEntity<List<OutputFindAllProductDTO>> findAll() {
        final var output = findAllProductUseCase.execute();
        return ResponseEntity.ok().body(output);
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity<Void> delete(@PathVariable("uuid") final UUID uuid) {
        final var input = new InputDeleteProductDTO(uuid);
        deleteProductUseCase.execute(input);
        return ResponseEntity.noContent().build();
    }
}
