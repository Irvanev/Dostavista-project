package com.delivery.mainservice.models;

import java.util.UUID;

public class OrderStatusMessage {
        private UUID courierId;
        private int price;
        private String requisite;

    public OrderStatusMessage(UUID courierId, int price, String requisite) {
        this.courierId = courierId;
        this.price = price;
        this.requisite = requisite;
    }

    public UUID getCourierId() {
        return courierId;
    }

    public void setCourierId(UUID courierId) {
        this.courierId = courierId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    @Override
    public String toString() {
        return "OrderStatusMessage{" +
                "courierId=" + courierId +
                ", price=" + price +
                ", requisite='" + requisite + '\'' +
                '}';
    }
}
