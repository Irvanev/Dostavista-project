package com.delivery.contractfirst.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CourierRequest(
        @NotBlank(message = "Имя обязательно")
        @Schema(
                description = "Имя пользвателя",
                name = "firstName",
                type = "string",
                example = "Viataly")
        String firstName,

        @NotBlank(message = "Фамилия обязательно")
        @Schema(
                description = "Фамилия пользвателя",
                name = "lastName",
                type = "string",
                example = "Irvanev")
        String lastName,

        @NotBlank(message = "Почта обязательна")
        @Email(message = "Почта должна быть корректна")
        @Schema(
                description = "Почта пользвателя",
                name = "email",
                type = "string",
                example = "test@mail.ru")
        String email,

        @NotBlank(message = "Номер телефона обязательно")
        @Size(min = 11, max = 11, message = "Номер телефона дожен быть корректный")
        @Schema(
                description = "Номер телефона пользвателя",
                name = "phone",
                type = "string",
                example = "77777777777")
        String phone,

        @Schema(
                description = "Адрес пользвателя",
                name = "address",
                type = "string",
                example = "77777777777")
        String address,

        @Schema(
                description = "Банковские реквизиты пользвателя",
                name = "requisite",
                type = "string",
                example = "73902840294820482-")
        String requisite
) {
}
