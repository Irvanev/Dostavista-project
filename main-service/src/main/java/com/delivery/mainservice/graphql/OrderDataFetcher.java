package com.delivery.mainservice.graphql;

import com.delivery.mainservice.dtos.orderDtos.CreateOrderDto;
import com.delivery.mainservice.dtos.orderDtos.OrderDto;
import com.delivery.mainservice.models.entities.Orders;
import com.delivery.mainservice.repositories.OrderRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@DgsComponent
public class OrderDataFetcher {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderDataFetcher(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @DgsQuery
    public Optional<OrderDto> findOrderById(@InputArgument UUID id) {
        return orderRepository.findById(id).map(orders -> modelMapper.map(orders, OrderDto.class));
    }

    @DgsQuery
    public List<OrderDto> findAllOrders() {
        return orderRepository.findAll().stream().map(orders -> modelMapper.map(orders, OrderDto.class))
                .collect(Collectors.toList());
    }

    @DgsMutation
    public OrderDto createOrder(CreateOrderDto createFeedbackDto) {
        Orders orders = modelMapper.map(createFeedbackDto, Orders.class);

        orders.setCreatedAt(new Date());

        return modelMapper.map(orderRepository.saveAndFlush(orders), OrderDto.class);
    }

    @DgsMutation
    public boolean deleteOrder(UUID id) {
        orderRepository.deleteById(id);
        return true;
    }
}
