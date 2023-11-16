package com.github.product.transportlayers.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UpdateProductRequest(
        @Schema(example = "Id")
        @NotNull(message = "Id cannot be null")
        Long id,
        @Schema(example = "Rice")
        @Size(max = 256, message = "The maximum of characters are 256")
        String name,
        @Schema(example = "Integral rice")
        @Size(max = 256, message = "The maximum of characters are 256")
        String description,
        @Schema(example = "12.99")
        @Min(0)
        BigDecimal price,
        @Schema(example = "2025-10-10")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate expirationDate,
        @Schema(example = "10")
        Integer stock,
        @Schema(example = "Walmart")
        @Size(max = 256, message = "The maximum of characters are 256")
        String supplier,
        Boolean active) {
}
