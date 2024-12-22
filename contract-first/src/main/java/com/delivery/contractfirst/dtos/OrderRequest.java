package com.delivery.contractfirst.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderRequest(
        @Positive
        @NotNull(message = "ID заказчика обязательно")
        @Schema(
                description = "ID заказчика",
                name = "customerId",
                type = "integer",
                example = "12345"
        )
        Long customerId,

        @NotBlank(message = "Адрес отправки обязательно")
        @Schema(
                description = "Адрес отправки",
                name = "pickupAddress",
                type = "string",
                example = "ул. Ленина, 1, Москва"
        )
        String pickupAddress,

        @NotBlank(message = "Адрес получения обязательно")
        @Schema(
                description = "Адрес получения",
                name = "deliveryAddress",
                type = "string",
                example = "ул. Пушкина, 15, Москва"
        )
        String deliveryAddress,

        @Schema(
                description = "Описание заказа",
                name = "description",
                type = "string",
                example = "Упаковка хрупкого товара"
        )
        String description,

        @NotBlank(message = "Вес обязательно")
        @Schema(
                description = "Вес заказа",
                name = "weight",
                type = "string",
                example = "5.5"
        )
        String weight
) {
}
