package com.delivery.contractfirst.fetchers;

import com.delivery.contractfirst.dtos.OrderRequest;
import com.delivery.contractfirst.dtos.OrderResponse;
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
@Tag(name = "Orders", description = "GraphQL API для управления заказами")
public interface OrderFetcher {

    @DgsQuery
    @Operation(
            summary = "Получить заказ по ID",
            description = "Возвращает данные заказа по указанному идентификатору"
    )
    Optional<OrderResponse> findOrderById(@InputArgument Long id);

    @DgsMutation
    @Operation(
            summary = "Создать заказ",
            description = "Создает новый заказ с указанными данными",
            requestBody = @RequestBody(
                    description = "Информация о новом заказе",
                    required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderRequest.class))
            )
    )
    OrderResponse createOrder(OrderRequest orderRequest);

    @DgsMutation
    @Operation(
            summary = "Редактировать данные заказа по ID",
            description = "Обновляет данные существующего заказа по указанному идентификатору",
            requestBody = @RequestBody(
                    description = "Обновленные данные заказа",
                    required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderRequest.class))
            )
    )
    OrderResponse updateOrder(@InputArgument Long id, OrderRequest orderRequest);

    @DgsMutation
    @Operation(
            summary = "Удалить заказ по ID",
            description = "Удаляет заказ по указанному идентификатору"
    )
    boolean deleteOrder(@InputArgument Long id);
}
