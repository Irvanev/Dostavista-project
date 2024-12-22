package com.delivery.contractfirst.dtos;

import java.util.Date;

public record OrderResponse(
    Long id,
    Long customerId,
    String pickupAddress,
    String deliveryAddress,
    String description,
    String weight,
    OrderStatusEnum status,
    Date createdAt
) {
}
