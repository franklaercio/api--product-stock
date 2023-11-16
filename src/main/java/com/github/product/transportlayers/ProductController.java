package com.github.product.transportlayers;

import com.github.product.transportlayers.data.CreateProductRequest;
import com.github.product.transportlayers.data.CreateProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Product", description = "Endpoints of manager product stock")
public interface ProductController {

    @Operation(summary = "Create a product", description = "This endpoint can be create or add one product in stock.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create product with success"),
            @ApiResponse(responseCode = "400", description = "One of items it's invalid", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal error", content = @Content)
    })
    ResponseEntity<CreateProductResponse> create(CreateProductRequest request);
}