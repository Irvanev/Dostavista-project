package com.delivery.mainservice.services.impl;

import com.delivery.mainservice.dtos.orderDtos.CreateOrderDto;
import com.delivery.mainservice.dtos.orderDtos.OrderDto;
import com.delivery.mainservice.models.entities.Orders;
import com.delivery.mainservice.models.enums.OrderStatusEnum;
import com.delivery.mainservice.repositories.OrderRepository;
import com.delivery.mainservice.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final RabbitTemplate rabbitTemplate;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, @Qualifier("rabbitTemplate") RabbitTemplate rabbitTemplate) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.rabbitTemplate = rabbitTemplate;
    }


    @Override
    public OrderDto createOrder(CreateOrderDto createOrderDto) {
        Orders order = modelMapper.map(createOrderDto, Orders.class);
        order.setCreatedAt(new Date());
        order.setStatus(OrderStatusEnum.CREATED);
        order.setId(null);

        Orders saveOrder = orderRepository.saveAndFlush(order);
        String message = "Был создан заказа №" + order.getId().toString();
        rabbitTemplate.convertAndSend("testExchange","notification.key", message);

        return modelMapper.map(saveOrder, OrderDto.class);
    }

    @Override
    public Optional<OrderDto> getOrderById(UUID id) {
        return orderRepository.findById(id).map(orderDto -> modelMapper.map(orderDto, OrderDto.class));
    }

    @Override
    public Page<OrderDto> getAllOrders(Pageable pageable) {
        Page<Orders> ordersPage = orderRepository.findAll(pageable);
        return ordersPage.map(order -> modelMapper.map(order, OrderDto.class));
    }

    @Override
    public void deleteOrder(UUID id) {
        orderRepository.deleteById(id);
    }

    @Override
    public OrderDto editOrder(UUID id, CreateOrderDto createOrderDto) {
        Orders order = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Order not found"));

        modelMapper.map(createOrderDto, order);

        return modelMapper.map(orderRepository.save(order), OrderDto.class);
    }
}
