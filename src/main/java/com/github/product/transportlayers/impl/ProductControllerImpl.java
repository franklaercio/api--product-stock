package com.github.product.transportlayers.impl;

import com.github.product.entities.Product;
import com.github.product.interactors.ProductUseCase;
import com.github.product.transportlayers.ProductController;
import com.github.product.transportlayers.data.CreateProductRequest;
import com.github.product.transportlayers.data.CreateProductResponse;
import com.github.product.transportlayers.data.UpdateProductRequest;
import com.github.product.transportlayers.data.UpdateProductResponse;
import com.github.product.transportlayers.mappers.CreateProductMapper;
import com.github.product.transportlayers.mappers.UpdateProductMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductControllerImpl implements ProductController {

    private final CreateProductMapper createProductMapper = CreateProductMapper.INSTANCE;
    private final UpdateProductMapper updateProductMapper = UpdateProductMapper.INSTANCE;

    private final ProductUseCase productUseCase;

    public ProductControllerImpl(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @Override
    @PostMapping
    public ResponseEntity<CreateProductResponse> create(@Valid @RequestBody CreateProductRequest request) {
        Product product = this.createProductMapper.sourceToDestination(request);
        Product response = this.productUseCase.save(product);

        return ResponseEntity.ok(createProductMapper.destinationToSource(response));
    }

    @Override
    @PutMapping
    public ResponseEntity<UpdateProductResponse> update(@Valid @RequestBody UpdateProductRequest request) {
        Product product = this.updateProductMapper.sourceToDestination(request);
        Product response = this.productUseCase.update(product);

        return ResponseEntity.ok(updateProductMapper.destinationToSource(response));
    }
}
