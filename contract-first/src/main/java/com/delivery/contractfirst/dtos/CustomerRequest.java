package com.delivery.contractfirst.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CustomerRequest(
        @NotBlank(message = "Имя обязательно")
        @Schema(
                description = "first name of the user",
                name = "firstName",
                type = "string",
                example = "Vatsal"
        )
        String firstName,

        @NotBlank(message = "Фамилия обязательна")
        @Schema(
                description = "last name of the user",
                name = "lastName",
                type = "string",
                example = "Patel"
        )
        String lastName,

        @NotBlank(message = "Почта обязательна")
        @Email(message = "Почта должна быть корректна")
        @Schema(
                description = "email address of the user",
                name = "email",
                type = "string",
                example = "vatsal.patel@example.com"
        )
        String email,

        @NotBlank(message = "Номер телефона обязательно")
        @Size(min = 11, max = 11, message = "Номер телефона должен быть корректный")
        @Schema(
                description = "phone number of the user",
                name = "phone",
                type = "string",
                example = "98765432100"
        )
        String phone
) {
}
