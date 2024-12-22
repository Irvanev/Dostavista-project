package com.delivery.mainservice.services;

import com.delivery.mainservice.dtos.orderDtos.CreateOrderDto;
import com.delivery.mainservice.dtos.orderDtos.OrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    OrderDto createOrder(CreateOrderDto createOrderDto);
    Optional<OrderDto> getOrderById(UUID id);
    Page<OrderDto> getAllOrders(Pageable pageable);
    void deleteOrder(UUID id);
    OrderDto editOrder(UUID id, CreateOrderDto createOrderDto);
}
