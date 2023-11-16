package com.github.product.repositories;

import com.github.product.entities.Product;

import java.util.List;

public interface ProductRepository {

    Product findById(Long id);

    Product save(Product product);

    Product update(Product product);

    List<Product> findAll();
}
