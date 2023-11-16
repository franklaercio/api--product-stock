package com.github.product.interactors;

import com.github.product.entities.Product;
import com.github.product.exceptions.NotFoundException;
import com.github.product.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUseCase {

    private final ProductRepository productRepository;

    public ProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    public Product update(Product product) {
        Product productFounded = this.productRepository.findById(product.getId());

        if(productFounded == null) {
            throw new NotFoundException("Could not found this product!");
        }

        ProductUpdater.updateProduct(productFounded, product);

        return this.productRepository.update(productFounded);
    }

    public Product findById(Long id) {
        Product product = this.productRepository.findById(id);

        if(product == null) {
            throw new NotFoundException("Could not found this product!");
        }

        return product;
    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }
}
