package com.delivery.contractfirst.controllers;

import com.delivery.contractfirst.dtos.OrderCourierRequest;
import com.delivery.contractfirst.dtos.OrderCourierResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Tag(name = "orders")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})

public interface OrderCourierApi {
    @Operation(summary = "Создать заказ курьеру")
    @PostMapping(value = "/api/order", produces = MediaType.APPLICATION_JSON_VALUE)
    OrderCourierResponse createOrderCourier(@Valid @RequestBody OrderCourierRequest request);

    @Operation(summary = "Получить заказ курьера по ID")
    @GetMapping(value = "/api/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    OrderCourierResponse getOrderCourier(@PathVariable("id") Long id);

    @Operation(summary = "Получить все заказы курьера")
    @GetMapping(value = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    OrderCourierResponse getAllOrdersCourier();

    @Operation(summary = "Редактировать данные заказа у курьера")
    @PutMapping(value = "/api/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    OrderCourierResponse editOrderCourier(@PathVariable("id") Long id, @Valid @RequestBody OrderCourierRequest request);

    @Operation(summary = "Удалить заказ курьера")
    @PutMapping(value = "/api/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteOrderCourier(@PathVariable("id") Long id);
}
