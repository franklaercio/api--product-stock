package com.github.product.transportlayers.mappers;

import com.github.product.entities.Product;
import com.github.product.transportlayers.data.CreateProductRequest;
import com.github.product.transportlayers.data.ProductResponse;
import com.github.product.transportlayers.data.UpdateProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product sourceToDestination(CreateProductRequest source);

    ProductResponse destinationToSource(Product destination);

    Product sourceToDestination(UpdateProductRequest source);

    List<ProductResponse> sourceListToDestination(List<Product> source);
}
