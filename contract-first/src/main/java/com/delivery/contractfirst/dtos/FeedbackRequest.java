package com.delivery.contractfirst.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.Date;

public record FeedbackRequest(
        @NotBlank(message = "ID заказчика обязателен")
        @Schema(
                description = "ID заказчика",
                name = "customerId",
                type = "integer",
                example = "12345"
        )
        Long customerId,

        @NotBlank(message = "ID курьера обязательно")
        @Schema(
                description = "ID курьера",
                name = "courierId",
                type = "integer",
                example = "67890"
        )
        Long courierId,

        @Min(value = 0)
        @Max(value = 5)
        @Positive
        @NotBlank(message = "Рейтинг обязателен")
        @Schema(
                description = "Оценка, выставленная пользователем (от 0 до 5)",
                name = "rating",
                type = "integer",
                example = "4"
        )
        int rating,

        @Schema(
                description = "Комментарий к отзыву",
                name = "comment",
                type = "string",
                example = "Отличная доставка, курьер был очень вежлив!"
        )
        String comment,

        @Schema(
                description = "Дата создания отзыва",
                name = "createdAt",
                type = "string",
                example = "2024-11-14T12:34:56"
        )
        Date createdAt
) {
}
