package com.delivery.mainservice.dtos.orderCourierDtos;

import java.util.UUID;

public class CreateOrderCourierDto {
    private UUID orderId;
    private UUID courierId;

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getCourierId() {
        return courierId;
    }

    public void setCourierId(UUID courierId) {
        this.courierId = courierId;
    }
}
