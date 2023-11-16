package com.github.product.transportlayers;

import com.github.product.transportlayers.data.CreateProductRequest;
import com.github.product.transportlayers.data.ProductResponse;
import com.github.product.transportlayers.data.UpdateProductRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Product", description = "Endpoints of manager product stock")
public interface ProductController {

    @Operation(summary = "Create a product", description = "This endpoint can be create or add one product in stock.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product created with success"),
            @ApiResponse(responseCode = "400", description = "One of items it's invalid", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content)
    })
    ResponseEntity<ProductResponse> create(CreateProductRequest request);

    @Operation(summary = "Update one product", description = "This endpoint can be update one product in stock.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated with success"),
            @ApiResponse(responseCode = "400", description = "One of items it's invalid", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content)
    })
    ResponseEntity<ProductResponse> update(UpdateProductRequest request);

    @Operation(summary = "Find one product by id", description = "This endpoint can be use to find one product in stock.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product founded with success"),
            @ApiResponse(responseCode = "400", description = "You need to inform the id", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content)
    })
    ResponseEntity<ProductResponse> findById(Long id);

    @Operation(summary = "Find all products", description = "This endpoint can be use to find all products in stock.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products founded with success"),
            @ApiResponse(responseCode = "400", description = "You need to check your request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content)
    })
    ResponseEntity<List<ProductResponse>> findAll();

    @Operation(summary = "Delete physic product", description = "This endpoint can be use to delete one product in stock.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product has been deleted with success"),
            @ApiResponse(responseCode = "400", description = "You need to check your request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content)
    })
    ResponseEntity<Void> deletePhysicById(Long id);

    @Operation(summary = "Delete logic product", description = "This endpoint can be use to delete one product in stock.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product has been deleted with success"),
            @ApiResponse(responseCode = "400", description = "You need to check your request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content)
    })
    ResponseEntity<Void> deleteLogicById(Long id);
}
