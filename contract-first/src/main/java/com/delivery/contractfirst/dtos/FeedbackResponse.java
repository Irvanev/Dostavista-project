package com.delivery.contractfirst.dtos;

import java.util.Date;

public record FeedbackResponse(
        Long id,
        Long customerId,
        Long courierId,
        int rating,
        String comment,
        Date createdAt
) {
}
