package com.github.product.datasources;

import com.github.product.datasources.entities.ProductEntity;
import com.github.product.datasources.jpa.ProductJpaRepository;
import com.github.product.datasources.mappers.ProductEntityMapper;
import com.github.product.entities.Product;
import com.github.product.exceptions.InternalServerError;
import com.github.product.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDataSource implements ProductRepository {

    private final ProductEntityMapper mapper = ProductEntityMapper.INSTANCE;

    private final ProductJpaRepository productJpaRepository;

    public ProductDataSource(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Product findById(Long id) {
        try {
            Optional<ProductEntity> entity = this.productJpaRepository.findById(id);
            return entity.map(this.mapper::destinationToSource).orElse(null);
        } catch (Exception ex) {
            throw new InternalServerError("Could not possible find this product: " + id);
        }
    }

    @Override
    public Product save(Product product) {
        try {
            ProductEntity entity = mapper.sourceToDestination(product);
            entity.setActive(false);

            ProductEntity saved = this.productJpaRepository.save(entity);

            return this.mapper.destinationToSource(saved);
        } catch (Exception ex) {
            throw new InternalServerError("Could not possible save this product: " + product.getName());
        }
    }

    @Override
    public Product update(Product product) {
        try {
            ProductEntity entity = mapper.sourceToDestination(product);
            ProductEntity updated = this.productJpaRepository.save(entity);

            return this.mapper.destinationToSource(updated);
        } catch (Exception ex) {
            throw new InternalServerError("Could not possible update this product: " + product.getId());
        }
    }

    @Override
    public List<Product> findAll() {
        try {
            List<ProductEntity> list = this.productJpaRepository.findAll();

            return this.mapper.sourceListToDestination(list);
        } catch (Exception ex) {
            throw new InternalServerError("Could not possible to find all products");
        }
    }
}
