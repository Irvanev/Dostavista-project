package com.delivery.contractfirst.fetchers;

import com.delivery.contractfirst.dtos.OrderCourierRequest;
import com.delivery.contractfirst.dtos.OrderCourierResponse;
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
@Tag(name = "OrderCouriers", description = "GraphQL API для управления заказами курьеров")
public interface OrderCourierFetcher {

    @DgsQuery
    @Operation(
            summary = "Получить заказ курьера по ID",
            description = "Возвращает данные заказа курьера по указанному идентификатору"
    )
    Optional<OrderCourierResponse> findOrderCourierById(@InputArgument Long id);

    @DgsMutation
    @Operation(
            summary = "Создать заказ курьера",
            description = "Создает новый заказ курьера с указанными данными",
            requestBody = @RequestBody(
                    description = "Информация о новом заказе курьера",
                    required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderCourierRequest.class))
            )
    )
    OrderCourierResponse createOrderCourier(OrderCourierRequest orderCourierRequest);

    @DgsMutation
    @Operation(
            summary = "Редактировать данные заказа курьера по ID",
            description = "Обновляет данные существующего заказа курьера по указанному идентификатору",
            requestBody = @RequestBody(
                    description = "Обновленные данные заказа курьера",
                    required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderCourierRequest.class))
            )
    )
    OrderCourierResponse updateOrderCourier(@InputArgument Long id, OrderCourierRequest orderCourierRequest);

    @DgsMutation
    @Operation(
            summary = "Удалить заказ курьера по ID",
            description = "Удаляет заказ курьера по указанному идентификатору"
    )
    boolean deleteOrderCourier(@InputArgument Long id);
}
