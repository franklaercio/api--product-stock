package com.github.product.transportlayers.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CreateProductRequest(
        @Schema(example = "Rice")
        @NotNull(message = "Name cannot be null")
        @Size(max = 256, message = "The maximum of characters are 256")
        String name,
        @Schema(example = "Integral rice")
        @NotNull(message = "Description cannot be null")
        @Size(max = 256, message = "The maximum of characters are 256")
        String description,
        @Schema(example = "12.99")
        @NotNull(message = "Price cannot be null")
        @Min(0)
        BigDecimal price,
        @Schema(example = "2025-10-10")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @NotNull(message = "Expiration date cannot be null")
        LocalDate expirationDate,
        @Schema(example = "10")
        Integer stock,
        @Schema(example = "Walmart")
        @Size(max = 256, message = "The maximum of characters are 256")
        String supplier) {
}
