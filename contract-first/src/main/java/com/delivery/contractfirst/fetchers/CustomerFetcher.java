package com.delivery.contractfirst.fetchers;

import com.delivery.contractfirst.dtos.CustomerRequest;
import com.delivery.contractfirst.dtos.CustomerResponse;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Optional;

@DgsComponent
@Tag(name = "Customers", description = "GraphQL API для управления заказчиками")
public interface CustomerFetcher {
    @DgsQuery
    @Operation(
            summary = "Получить заказчика по ID",
            description = "Возвращает данные заказчика по указанному идентификатору"
    )
    Optional<CustomerResponse> findCustomerById(@InputArgument Long id);

    @DgsMutation
    @Operation(
            summary = "Создать заказчика",
            description = "Создает нового заказчика с указанными данными",
            requestBody = @RequestBody(
                    description = "Информация о заказчике",
                    required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerRequest.class))
            )
    )
    CustomerResponse createCustomer(CustomerRequest customerRequest);

    @DgsMutation
    @Operation(
            summary = "Редактировать данные заказчика",
            description = "Обновляет данные существующего заказчика по идентификатору",
            requestBody = @RequestBody(
                    description = "Обновленные данные заказчика",
                    required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerRequest.class))
            )
    )
    CustomerResponse updateCustomer(@InputArgument Long id, CustomerRequest customerRequest);

    @DgsMutation
    @Operation(
            summary = "Удалить заказчика",
            description = "Удаляет заказчика по указанному идентификатору"
    )
    boolean deleteCustomer(@InputArgument Long id);
}
