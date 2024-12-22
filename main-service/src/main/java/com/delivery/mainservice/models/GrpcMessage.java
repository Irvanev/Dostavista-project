package com.delivery.mainservice.models;

import java.util.UUID;

public class GrpcMessage {
    private int price;
    private int countOrder;
    private UUID courierId;

    public GrpcMessage(int price, int countOrder, UUID courierId) {
        this.price = price;
        this.countOrder = countOrder;
        this.courierId = courierId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCountOrder() {
        return countOrder;
    }

    public void setCountOrder(int countOrder) {
        this.countOrder = countOrder;
    }

    public UUID getCourierId() {
        return courierId;
    }

    public void setCourierId(UUID courierId) {
        this.courierId = courierId;
    }

    @Override
    public String toString() {
        return "GrpcMessage{" +
                "price=" + price +
                ", countOrder=" + countOrder +
                ", courierId=" + courierId +
                '}';
    }
}
