package com.delivery.contractfirst.controllers;

import com.delivery.contractfirst.dtos.OrderRequest;
import com.delivery.contractfirst.dtos.OrderResponse;
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

public interface OrderApi {
    @Operation(summary = "Создать заказ")
    @PostMapping(value = "/api/order", produces = MediaType.APPLICATION_JSON_VALUE)
    OrderResponse createOrder(@Valid @RequestBody OrderRequest request);

    @Operation(summary = "Получить заказ по ID")
    @GetMapping(value = "/api/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    OrderResponse getOrder(@PathVariable("id") Long id);

    @Operation(summary = "Получить все заказы")
    @GetMapping(value = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    OrderResponse getAllOrders();

    @Operation(summary = "Редактировать данные заказа")
    @PutMapping(value = "/api/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    OrderResponse editOrder(@PathVariable("id") Long id, @Valid @RequestBody OrderRequest request);

    @Operation(summary = "Удалить заказ")
    @PutMapping(value = "/api/order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteOrder(@PathVariable("id") Long id);
}
