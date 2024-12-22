package com.delivery.contractfirst.dtos;

import java.util.Date;

public record OrderCourierResponse(
        Long id,
        Long orderId,
        Long courierId,
        OrderStatusEnum status,
        Date assignedAt
) {
}
