package com.delivery.contractfirst.fetchers;


import com.delivery.contractfirst.dtos.CourierRequest;
import com.delivery.contractfirst.dtos.CourierResponse;
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
@Tag(name = "Couriers", description = "GraphQL API для управления курьерами")
public interface CourierFetcher {
    @DgsQuery
    @Operation(
            summary = "Получить курьера по ID",
            description = "Возвращает данные курьера по указанному идентификатору"
    )
    Optional<CourierResponse> findCourierById(@InputArgument Long id);

    @DgsMutation
    @Operation(
            summary = "Создать курьера",
            description = "Создает нового курьера с указанными данными",
            requestBody = @RequestBody(
                    description = "Информация о курьере",
                    required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourierRequest.class))
            )
    )
    CourierResponse createCourier(CourierRequest courierRequest);

    @DgsMutation
    @Operation(
            summary = "Редактировать данные курьера",
            description = "Обновляет данные существующего курьера по идентификатору",
            requestBody = @RequestBody(
                    description = "Обновленные данные курьера",
                    required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CourierRequest.class))
            )
    )
    CourierResponse updateCourier(@InputArgument Long id, CourierRequest courierRequest);

    @DgsMutation
    @Operation(
            summary = "Удалить курьера",
            description = "Удаляет курьера по указанному идентификатору"
    )
    boolean deleteCourier(@InputArgument Long id);
}
