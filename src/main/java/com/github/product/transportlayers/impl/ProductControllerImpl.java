package com.github.product.transportlayers.impl;

import com.github.product.entities.Product;
import com.github.product.interactors.CreateProductUseCase;
import com.github.product.transportlayers.ProductController;
import com.github.product.transportlayers.data.CreateProductRequest;
import com.github.product.transportlayers.data.CreateProductResponse;
import com.github.product.transportlayers.mappers.CreateProductMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductControllerImpl implements ProductController {

    private final CreateProductMapper createProductMapper = CreateProductMapper.INSTANCE;

    private final CreateProductUseCase createProductUseCase;

    public ProductControllerImpl(CreateProductUseCase createProductUseCase) {
        this.createProductUseCase = createProductUseCase;
    }

    @Override
    @PostMapping
    public ResponseEntity<CreateProductResponse> create(@Valid @RequestBody CreateProductRequest request) {
        Product product = this.createProductMapper.sourceToDestination(request);
        Product response = this.createProductUseCase.execute(product);

        return ResponseEntity.ok(createProductMapper.destinationToSource(response));
    }
}
