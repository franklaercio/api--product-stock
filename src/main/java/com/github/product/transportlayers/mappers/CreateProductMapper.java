package com.github.product.transportlayers.mappers;

import com.github.product.entities.Product;
import com.github.product.transportlayers.data.CreateProductRequest;
import com.github.product.transportlayers.data.CreateProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreateProductMapper {

    CreateProductMapper INSTANCE = Mappers.getMapper(CreateProductMapper.class);

    Product sourceToDestination(CreateProductRequest source);

    CreateProductResponse destinationToSource(Product destination);
}
