package com.delivery.payservice.models;

import java.io.Serializable;

public class OrderPaymentMessage implements Serializable {
    private Long courierId;
    private int price;
    private String requisite;

    // Getters и Setters
    public Long getCourierId() {
        return courierId;
    }

    public void setCourierId(Long courierId) {
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
        return "OrderPaymentMessage{" +
                "courierId=" + courierId +
                ", price=" + price +
                ", requisite='" + requisite + '\'' +
                '}';
    }
}
