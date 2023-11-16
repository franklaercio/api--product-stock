package com.github.product.transportlayers.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateProductResponse(
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
