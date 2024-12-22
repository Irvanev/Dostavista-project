package com.delivery.contractfirst.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderCourierRequest(
        @Positive
        @NotNull(message = "ID заказа обязателен")
        @Schema(
                description = "ID заказа",
                name = "orderId",
                type = "integer",
                example = "12345"
        )
        Long orderId,

        @Positive
        @NotNull(message = "ID курьера обязателен")
        @Schema(
                description = "ID курьера",
                name = "courierId",
                type = "integer",
                example = "67890"
        )
        Long courierId
) {
}
