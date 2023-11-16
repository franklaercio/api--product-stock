package com.github.product.transportlayers.impl;

import com.github.product.entities.Product;
import com.github.product.interactors.ProductUseCase;
import com.github.product.transportlayers.ProductController;
import com.github.product.transportlayers.data.CreateProductRequest;
import com.github.product.transportlayers.data.ProductResponse;
import com.github.product.transportlayers.data.UpdateProductRequest;
import com.github.product.transportlayers.mappers.ProductMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductControllerImpl implements ProductController {

    private final ProductMapper mapper = ProductMapper.INSTANCE;

    private final ProductUseCase productUseCase;

    public ProductControllerImpl(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @Override
    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody CreateProductRequest request) {
        Product product = this.mapper.sourceToDestination(request);
        Product response = this.productUseCase.save(product);

        return ResponseEntity.ok(mapper.destinationToSource(response));
    }

    @Override
    @PutMapping
    public ResponseEntity<ProductResponse> update(@Valid @RequestBody UpdateProductRequest request) {
        Product product = this.mapper.sourceToDestination(request);
        Product response = this.productUseCase.update(product);

        return ResponseEntity.ok(mapper.destinationToSource(response));
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        Product response = this.productUseCase.findById(id);

        return ResponseEntity.ok(mapper.destinationToSource(response));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        List<Product> response = this.productUseCase.findAll();

        return ResponseEntity.ok(mapper.sourceListToDestination(response));
    }

    @Override
    @DeleteMapping("/physic/{id}")
    public ResponseEntity<Void> deletePhysicById(@PathVariable Long id) {
        this.productUseCase.deletePhysic(id);

        return ResponseEntity.noContent().build();
    }

    @Override
    @DeleteMapping("/logic/{id}")
    public ResponseEntity<Void> deleteLogicById(@PathVariable Long id) {
        this.productUseCase.deleteLogic(id);

        return ResponseEntity.noContent().build();
    }
}
