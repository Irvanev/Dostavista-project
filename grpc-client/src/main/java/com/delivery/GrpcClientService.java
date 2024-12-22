package com.delivery;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import order.Commission;
import order.OrderServiceGrpc;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    private final OrderServiceGrpc.OrderServiceBlockingStub stub;

    public GrpcClientService() {
        // Настраиваем gRPC канал
        ManagedChannel grpcChannel = ManagedChannelBuilder.forAddress("localhost", 8888)
                .usePlaintext()
                .build();
        this.stub = OrderServiceGrpc.newBlockingStub(grpcChannel);
    }

    @RabbitListener(queues = RabbitConfig.ORDER_QUEUE)
    public void handleMessage(String message) {
        System.out.println("Received message from RabbitMQ: " + message);

        try {
            String[] parts = message.split(",");
            int courierId = Integer.parseInt(parts[0].trim());
            int orderValue = Integer.parseInt(parts[1].trim());
            int countOrder = Integer.parseInt(parts[2].trim());

            // Формируем запрос
            Commission.OrderRequest request = Commission.OrderRequest.newBuilder()
                    .setCourierId(courierId)
                    .setOrderValue(orderValue)
                    .setCountOrder(countOrder)
                    .build();

            // Отправляем запрос через gRPC
            Commission.OrderResponse response = stub.processOrder(request);

            // Логируем результат
            System.out.println("Response from gRPC Server:");
            System.out.println("Courier ID: " + response.getCourierId());
            System.out.println("Commission Rate: " + response.getCommissionRate());
            System.out.println("Courier Earnings: " + response.getCourierEarnings());
            System.out.println("Platform Earnings: " + response.getPlatformEarnings());
        } catch (Exception e) {
            System.err.println("Error processing message: " + e.getMessage());
        }
    }
}
