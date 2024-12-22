package com.delivery.contractfirst.controllers;

import com.delivery.contractfirst.dtos.CustomerRequest;
import com.delivery.contractfirst.dtos.CustomerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Tag(name = "customers")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})

public interface CustomerApi {
    @Operation(summary = "Создать заказчика")
    @PostMapping(value = "/api/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerResponse createCustomer(@Valid @RequestBody CustomerRequest request);

    @Operation(summary = "Получить заказчика по ID")
    @GetMapping(value = "/api/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerResponse getCustomer(@PathVariable("id") Long id);

    @Operation(summary = "Получить всех заказчиков")
    @GetMapping(value = "/api/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerResponse getAllCustomers();

    @Operation(summary = "Редактировать данные заказчика")
    @PutMapping(value = "/api/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerResponse editCustomer(@PathVariable("id") Long id, @Valid @RequestBody CustomerRequest request);

    @Operation(summary = "Удалить заказчика")
    @PutMapping(value = "/api/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteCustomer(@PathVariable("id") Long id);
}
