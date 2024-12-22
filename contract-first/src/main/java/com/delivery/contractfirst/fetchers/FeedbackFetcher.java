package com.delivery.contractfirst.fetchers;

import com.delivery.contractfirst.dtos.FeedbackRequest;
import com.delivery.contractfirst.dtos.FeedbackResponse;
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
@Tag(name = "Feedbacks", description = "GraphQL API для управления отзывами")
public interface FeedbackFetcher {

    @DgsQuery
    @Operation(
            summary = "Получить отзыв по ID",
            description = "Возвращает данные отзыва по указанному идентификатору"
    )
    Optional<FeedbackResponse> findFeedbackById(@InputArgument Long id);

    @DgsMutation
    @Operation(
            summary = "Создать отзыв",
            description = "Создает новый отзыв с указанными данными",
            requestBody = @RequestBody(
                    description = "Информация о новом отзыве",
                    required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FeedbackRequest.class))
            )
    )
    FeedbackResponse createFeedback(FeedbackRequest feedbackRequest);

    @DgsMutation
    @Operation(
            summary = "Редактировать данные отзыва",
            description = "Обновляет данные существующего отзыва по идентификатору",
            requestBody = @RequestBody(
                    description = "Обновленные данные отзыва",
                    required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FeedbackRequest.class))
            )
    )
    FeedbackResponse updateFeedback(@InputArgument Long id, FeedbackRequest feedbackRequest);

    @DgsMutation
    @Operation(
            summary = "Удалить отзыв по ID",
            description = "Удаляет отзыв по указанному идентификатору"
    )
    boolean deleteFeedback(@InputArgument Long id);
}
