package com.github.product.transportlayers.mappers;

import com.github.product.entities.Product;
import com.github.product.transportlayers.data.ProductResponse;
import com.github.product.transportlayers.data.UpdateProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UpdateProductMapper {

    UpdateProductMapper INSTANCE = Mappers.getMapper(UpdateProductMapper.class);

    Product sourceToDestination(UpdateProductRequest source);

    ProductResponse destinationToSource(Product destination);
}
