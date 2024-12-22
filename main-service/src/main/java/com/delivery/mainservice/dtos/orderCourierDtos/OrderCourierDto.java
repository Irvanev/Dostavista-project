package com.delivery.mainservice.dtos.orderCourierDtos;


import com.delivery.mainservice.models.enums.OrderStatusEnum;

import java.util.Date;
import java.util.UUID;

public class OrderCourierDto {
    private UUID id;
    private Long orderId;
    private Long courierId;
    private OrderStatusEnum status;
    private Date assignedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCourierId() {
        return courierId;
    }

    public void setCourierId(Long courierId) {
        this.courierId = courierId;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    public Date getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(Date assignedAt) {
        this.assignedAt = assignedAt;
    }
}
