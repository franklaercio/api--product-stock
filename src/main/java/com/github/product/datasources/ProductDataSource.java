package com.github.product.datasources;

import com.github.product.datasources.entities.ProductEntity;
import com.github.product.datasources.jpa.ProductJpaRepository;
import com.github.product.datasources.mappers.ProductEntityMapper;
import com.github.product.entities.Product;
import com.github.product.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductDataSource implements ProductRepository {

    private final ProductEntityMapper mapper = ProductEntityMapper.INSTANCE;

    private final ProductJpaRepository productJpaRepository;

    public ProductDataSource(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = mapper.sourceToDestination(product);
        entity.setActive(false);

        ProductEntity saved = this.productJpaRepository.save(entity);

        return this.mapper.destinationToSource(saved);
    }
}
