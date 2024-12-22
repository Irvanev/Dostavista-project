package com.delivery.contractfirst.controllers;

import com.delivery.contractfirst.dtos.FeedbackRequest;
import com.delivery.contractfirst.dtos.FeedbackResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Tag(name = "feedbacks")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})

public interface FeedbackApi {
    @Operation(summary = "Создать отзыв")
    @PostMapping(value = "/api/feedback", produces = MediaType.APPLICATION_JSON_VALUE)
    FeedbackResponse createFeedback(@Valid @RequestBody FeedbackRequest request);

    @Operation(summary = "Получить отзыв по ID")
    @GetMapping(value = "/api/feedback/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    FeedbackResponse getFeedback(@PathVariable("id") Long id);

    @Operation(summary = "Получить все отзывы")
    @GetMapping(value = "/api/feedbacks", produces = MediaType.APPLICATION_JSON_VALUE)
    FeedbackResponse getAllFeedbacks();

    @Operation(summary = "Редактировать данные отзыва")
    @PutMapping(value = "/api/feedback/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    FeedbackResponse editFeedback(@PathVariable("id") Long id, @Valid @RequestBody FeedbackRequest request);

    @Operation(summary = "Удалить отзыв")
    @PutMapping(value = "/api/feedback/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteFeedback(@PathVariable("id") Long id);
}
