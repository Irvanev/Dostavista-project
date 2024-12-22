package com.delivery;

import io.grpc.stub.StreamObserver;
import order.Commission;
import order.OrderServiceGrpc;

public class OrderServiceImpl extends OrderServiceGrpc.OrderServiceImplBase {

    @Override
    public void processOrder(Commission.OrderRequest request, StreamObserver<Commission.OrderResponse> responseObserver) {
        int courierId = request.getCourierId();
        int orderValue = request.getOrderValue();
        int countOrder = request.getCountOrder();

        // Расчет комиссии
        float commissionRate = countOrder > 5 ? 0.10f : 0.15f;
        float platformEarnings = orderValue * commissionRate;
        float courierEarnings = orderValue - platformEarnings;

        // Создаем ответ
        Commission.OrderResponse response = Commission.OrderResponse.newBuilder()
                .setCourierId(courierId)
                .setCommissionRate(commissionRate)
                .setCourierEarnings(courierEarnings)
                .setPlatformEarnings(platformEarnings)
                .build();

        // Отправляем ответ
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
