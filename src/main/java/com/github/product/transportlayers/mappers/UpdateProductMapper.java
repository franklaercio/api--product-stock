package com.github.product.transportlayers.mappers;

import com.github.product.entities.Product;
import com.github.product.transportlayers.data.CreateProductRequest;
import com.github.product.transportlayers.data.CreateProductResponse;
import com.github.product.transportlayers.data.UpdateProductRequest;
import com.github.product.transportlayers.data.UpdateProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UpdateProductMapper {

    UpdateProductMapper INSTANCE = Mappers.getMapper(UpdateProductMapper.class);

    Product sourceToDestination(UpdateProductRequest source);

    UpdateProductResponse destinationToSource(Product destination);
}
