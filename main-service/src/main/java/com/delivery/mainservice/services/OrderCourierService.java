package com.delivery.mainservice.services;

import com.delivery.mainservice.dtos.orderCourierDtos.CreateOrderCourierDto;
import com.delivery.mainservice.dtos.orderCourierDtos.OrderCourierDto;
import com.delivery.mainservice.models.enums.OrderStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface OrderCourierService {
    OrderCourierDto createOrderCourier(CreateOrderCourierDto createOrderCourierDto);
    Page<OrderCourierDto> getAllOrdersCourier(Pageable pageable);
    Optional<OrderCourierDto> getOrderCourier(UUID id);
    void deleteOrderCourier(UUID id);
    OrderCourierDto editOrderCourier(UUID id, CreateOrderCourierDto createOrderCourierDto);
    OrderCourierDto updateOrderStatusByCourier(UUID courierId, UUID orderId, OrderStatusEnum newStatus);
}
