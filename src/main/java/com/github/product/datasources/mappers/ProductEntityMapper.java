package com.github.product.datasources.mappers;

import com.github.product.datasources.entities.ProductEntity;
import com.github.product.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductEntityMapper {

    ProductEntityMapper INSTANCE = Mappers.getMapper(ProductEntityMapper.class);

    ProductEntity sourceToDestination(Product source);

    Product destinationToSource(ProductEntity destination);
}
