package com.delivery.contractfirst.controllers;

import com.delivery.contractfirst.dtos.CourierRequest;
import com.delivery.contractfirst.dtos.CourierResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Tag(name = "couriers")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})
public interface CourierApi {
    @Operation(summary = "Создать курьера")
    @PostMapping(value = "/api/courier", produces = MediaType.APPLICATION_JSON_VALUE)
    CourierResponse createCourier(@Valid @RequestBody CourierRequest request);

    @Operation(summary = "Получить курьера по ID")
    @GetMapping(value = "/api/courier/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    CourierResponse getCourier(@PathVariable("id") Long id);

    @Operation(summary = "Получить всех курьеров")
    @GetMapping(value = "/api/couriers", produces = MediaType.APPLICATION_JSON_VALUE)
    CourierResponse getAllCouriers();

    @Operation(summary = "Редактировать данные курьера")
    @PutMapping(value = "/api/courier/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    CourierResponse editCourier(@PathVariable("id") Long id, @Valid @RequestBody CourierRequest request);

    @Operation(summary = "Удалить курьера")
    @PutMapping(value = "/api/courier/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteCourier(@PathVariable("id") Long id);
}
