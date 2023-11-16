package com.github.product.transportlayers.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UpdateProductResponse(
        @Schema(example = "1")
        Long id,
        @Schema(example = "Rice")
        String name,
        @Schema(example = "Integral rice")
        String description,
        @Schema(example = "12.99")
        BigDecimal price,
        @Schema(example = "2025-10-10")
        LocalDate expirationDate,
        @Schema(example = "10")
        Integer stock,
        @Schema(example = "Walmart")
        String supplier,
        Boolean active) {
}
