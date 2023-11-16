package com.github.product.datasources.mappers;

import com.github.product.datasources.entities.ProductEntity;
import com.github.product.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductEntityMapper {

    ProductEntityMapper INSTANCE = Mappers.getMapper(ProductEntityMapper.class);

    ProductEntity sourceToDestination(Product source);

    Product destinationToSource(ProductEntity destination);

    List<Product> sourceListToDestination(List<ProductEntity> source);
}
