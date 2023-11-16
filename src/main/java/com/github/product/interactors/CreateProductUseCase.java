package com.github.product.interactors;

import com.github.product.entities.Product;
import com.github.product.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCase {

    private final ProductRepository productRepository;

    public CreateProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product execute(Product product) {
        return this.productRepository.save(product);
    }
}
